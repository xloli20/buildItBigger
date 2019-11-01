package com.udacity.gradle.builditbigger.backend;

import com.example.javajokeslib.Jokes;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private Jokes myData;

    public MyBean(){
        myData = new Jokes();
    }

    public String getData() {
        return myData.getJoke();
    }

    public void setData(Jokes data) {
        myData = data;
    }
}