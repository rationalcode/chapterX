package com.example.admin.chapter;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomMasterTable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.example.admin.chapter.AppDatabase.getDatabase;


public class Main extends AppCompatActivity implements View.OnClickListener {


    static List <Chapter> chapterListTemp;
    static ChapterDAO chapterDAO;
    static AppDatabase db;
    ChapterListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



            //getDatabase(this);
            //Toast.makeText(this,"create db",Toast.LENGTH_SHORT).show();


        db = getDatabase(getApplicationContext());
        //chapterDAO = db.chapterDAO();


        Button getall = findViewById(R.id.getall);
        Button insert = findViewById(R.id.insert);
        getall.setOnClickListener(this);
        insert.setOnClickListener(this);
        chapterListTemp = new ArrayList<>();

        for (int i = 0; i<10; i++){

            Chapter current = new Chapter("Chapter"+ i+" ","notion "+Integer.toString(i));
            //chapterDAO.insert(current);

        }



        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        adapter= new ChapterListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //adapter.setChapter(chapterListTemp);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.getall:

                adapter.setChapter(db.chapterDAO().getAll());
                break;
            case R.id.insert:

                db.chapterDAO().insert(new Chapter("new Chapter"+new Random(10), "notion"));
                Log.d("dba","insert Chapter");
                break;
        }

    }
}
