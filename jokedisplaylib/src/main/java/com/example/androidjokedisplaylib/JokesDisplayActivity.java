package com.example.androidjokedisplaylib;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class JokesDisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes_display);

        TextView jokeTextView = findViewById(R.id.joke_text_view);
        Intent intent = getIntent();
        intent.getStringExtra("joke");
        jokeTextView.setText(intent.getStringExtra("joke"));

    }
}
