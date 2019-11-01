package com.example.javajokeslib;

import java.util.ArrayList;
import java.util.Random;

public class Jokes {

    public String getJoke() {
        ArrayList<String> jokes = new ArrayList<>();
        jokes.add("you're the joke hahaha !");
        jokes.add("Q: Why do Java programmers wear glasses? A: They can't C#.");
        jokes.add("Two computers in the same LAN chatting one night:\n" +
                "PC1: I was having a nightmare last night, it was so horrible.\n" +
                "PC2: Why, what did you dream about ?\n" +
                "PC1: I was sleeping, dreaming 0 1 1 0 1 0 0 0 1 0 when all of a sudden a 2 popped up!");

        Random rand = new Random();
        return jokes.get(rand.nextInt(jokes.size()));
    }
}
