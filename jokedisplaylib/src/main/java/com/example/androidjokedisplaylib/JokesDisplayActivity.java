package com.example.androidjokedisplaylib;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class JokesDisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes_display);

        TextView jokeTextView = findViewById(R.id.joke_text_view);
        Intent intent = getIntent();
        if (intent.hasExtra("joke")) {
            intent.getStringExtra("joke");
            jokeTextView.setText(intent.getStringExtra("joke"));
        }
    }
}
