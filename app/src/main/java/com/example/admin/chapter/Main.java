package com.example.admin.chapter;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomMasterTable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.example.admin.chapter.AppDatabase.getDatabase;


public class Main extends AppCompatActivity implements View.OnClickListener {


    static List <Chapter> chapterListTemp;
    static ChapterDAO chapterDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



            //getDatabase(this);
            //Toast.makeText(this,"create db",Toast.LENGTH_SHORT).show();

        getDatabase(getApplicationContext());
        Button selectAll = findViewById(R.id.selectall);
        selectAll.setOnClickListener(this);
        chapterListTemp = new ArrayList<>();

        for (int i = 0; i<10; i++){

            Chapter current = new Chapter(Integer.toString(i)+" ","notion "+Integer.toString(i));
            chapterDAO.insert(current);

        }

        chapterListTemp = chapterDAO.getAll();

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final ChapterListAdapter adapter = new ChapterListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter.setChapter(chapterListTemp);

    }

    @Override
    public void onClick(View v) {

        chapterListTemp = new ArrayList<>();
        chapterListTemp = chapterDAO.getAll();
//        for (int i = 0; i<10; i++){
//
//            Chapter current = new Chapter("i","notion i");
//            chapterList.add(current);
//
//        }


    }
}
