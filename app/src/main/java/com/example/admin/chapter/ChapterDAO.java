package com.example.admin.chapter;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ChapterDAO {

    @Query("SELECT * FROM chapters")
    List<Chapter> getAll();


    @Insert
    void insert(Chapter chapters);

    @Insert
    void insertAll(Chapter... chapters);

    @Delete
    void delete(Chapter chapters);
}
