package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

public class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {

    private final String TAG = EndpointsAsyncTask.class.getSimpleName();
    private MyApi myApiService = null;
    private Context context;
    private OnEventListener<String> mCallBack;
    public Exception mException;

    public  EndpointsAsyncTask(){
    }

    public EndpointsAsyncTask(Context context,OnEventListener callback) {
        mCallBack = callback;
        this.context = context;
    }

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

//        context = params[0].first;

        try {
            return myApiService.sayJoke().execute().getData();
        } catch (IOException e) {
            Log.d(TAG, "doInBackground: "+e.getMessage());
            return null;
        }
    }

    public interface OnEventListener<T> {
        public void onSuccess(String object);
        public void onFailure(Exception e);
    }



    @Override
    protected void onPostExecute(String result) {
        if (mCallBack != null) {
            if (mException == null) {
                mCallBack.onSuccess(result);
            } else {
                mCallBack.onFailure(mException);
            }
        }

        Log.d(TAG, "onPostExecute: result: "+result);
//        Intent intent = new Intent(context, JokesDisplayActivity.class);
//        intent.putExtra("joke",result);
//        context.startActivity(intent);
    }
}

