package com.udacity.gradle.builditbigger.paid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.androidjokedisplaylib.JokesDisplayActivity;
import com.example.javajokeslib.Jokes;

import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.R;

public class MainActivity extends AppCompatActivity {
    public final String TAG = com.udacity.gradle.builditbigger.MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void tellJoke(View view) {
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(getApplicationContext(),
                new EndpointsAsyncTask.OnEventListener() {
                    @Override
                    public void onSuccess(String object) {
                        Intent intent = new Intent(getApplicationContext(), JokesDisplayActivity.class);
                        intent.putExtra("joke", object);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Exception e) {

                    }
                });
        endpointsAsyncTask.execute();
    }
}