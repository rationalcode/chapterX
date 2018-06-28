package com.example.admin.chapter;

import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

    private final ChapterDAO chapterDAO;

    PopulateDbAsync(AppDatabase db) {
        chapterDAO = db.chapterDAO();
    }

    @Override
    protected Void doInBackground(final Void... params) {

        List<Chapter> chapters = new ArrayList<>();
        //chapterDAO.deleteAll();
        for (int i = 0; i <10 ; i++) {

            Chapter chapter = new Chapter("chapter "+i,"Hello");
            chapters.add(chapter);

        }

        chapterDAO.insertAll(chapters);


        return null;
    }
}