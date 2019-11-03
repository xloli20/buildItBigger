package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.androidjokedisplaylib.JokesDisplayActivity;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    public final String TAG = com.udacity.gradle.builditbigger.MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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