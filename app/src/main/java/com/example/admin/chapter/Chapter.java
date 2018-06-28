package com.example.admin.chapter;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity (tableName = "chapters")
public class Chapter {


    @PrimaryKey (autoGenerate = true)
    int id;

    @ColumnInfo (name = "title")
    String title;

    @ColumnInfo (name = "notion")
    String notion;

    public Chapter(String title, String notion) {
        this.title = title;
        this.notion = notion;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNotion() {
        return notion;
    }

    public void setNotion(String notion) {
        this.notion = notion;
    }
}
