package com.example.admin.chapter;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

@Database(entities = {Chapter.class},version = 1, exportSchema = false)

public abstract class AppDatabase extends RoomDatabase{

    public abstract ChapterDAO chapterDAO();



    private static AppDatabase INSTANCE;


    static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "chapters")
                            .addCallback(sRoomDatabaseCallback)
                            .allowMainThreadQueries()
                            .build();

                    Toast.makeText(context,"create db",Toast.LENGTH_LONG).show();

                }
            }
        }
        return INSTANCE;
    }

   private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };
}
