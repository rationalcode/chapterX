package com.example.admin.chapter;

import android.os.AsyncTask;

class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

    private final ChapterDAO chapterDAO;

    PopulateDbAsync(AppDatabase db) {
        chapterDAO = db.chapterDAO();
    }

    @Override
    protected Void doInBackground(final Void... params) {

        //chapterDAO.deleteAll();
        Chapter chapter = new Chapter("chapter 1","Hello");
        chapterDAO.insert(chapter);

        chapter = new Chapter("chapter 2","History");
        chapterDAO.insert(chapter);
        return null;
    }
}