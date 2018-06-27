package com.example.admin.chapter;

public abstract class Concept <T> {

    T id;
    T title;

    T getTitle (T title){
        return title;
    }
}
