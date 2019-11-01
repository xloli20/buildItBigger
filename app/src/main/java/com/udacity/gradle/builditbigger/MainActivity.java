package com.udacity.gradle.builditbigger;

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


public class MainActivity extends AppCompatActivity {
    public final String TAG = MainActivity.class.getSimpleName();

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
        //noinspection unchecked
        new EndpointsAsyncTask().execute(new Pair<Context, String>(this, "Manfred"));
        Intent intent = new Intent(this, JokesDisplayActivity.class);
        Jokes jokes = new Jokes();
        intent.putExtra("joke", jokes.getJoke());
        startActivity(intent);
    }
//
//    class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
//        private MyApi myApiService = null;
//        private Context context;
//
//        @Override
//        protected String doInBackground(Pair<Context, String>... params) {
//            if(myApiService == null) {  // Only do this once
//                MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
//                        new AndroidJsonFactory(), null)
//                        // options for running against local devappserver
//                        // - 10.0.2.2 is localhost's IP address in Android emulator
//                        // - turn off compression when running against local devappserver
//                        .setRootUrl("http://10.0.2.2:8080/_ah/api/")
//                        .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
//                            @Override
//                            public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
//                                abstractGoogleClientRequest.setDisableGZipContent(true);
//                            }
//                        });
//                // end options for devappserver
//
//                myApiService = builder.build();
//            }
//
//            context = params[0].first;
//            String name = params[0].second;
//
//            try {
//                return myApiService.sayJoke().execute().getData();
//            } catch (IOException e) {
//                return e.getMessage();
//            }
//        }
//
//        @Override
//        protected void onPostExecute(String result) {
//            Toast.makeText(context, result, Toast.LENGTH_LONG).show();
//        }
//    }
}
