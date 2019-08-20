package com.test.therickandmortyapp.data;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.test.therickandmortyapp.data.callbacks.DataCallback;
import com.test.therickandmortyapp.data.models.Episode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class EpisodeListAsyncTask extends AsyncTask<DataCallback<List<Episode>>, Void, List<Episode>> {

    private static final String TAG = EpisodeListAsyncTask.class.getSimpleName();

    private DataCallback callback;

    @Override
    protected List<Episode> doInBackground(DataCallback<List<Episode>>... dataCallbacks) {
        if (dataCallbacks == null || dataCallbacks.length == 0) {
            throw new RuntimeException("Callback not provided");
        }
        callback = dataCallbacks[0];

        URL url;
        HttpURLConnection urlConnection = null;
        String server_response;

        try {
            url = new URL("https://rickandmortyapi.com/api/episode/");
            urlConnection = (HttpURLConnection) url.openConnection();

            int responseCode = urlConnection.getResponseCode();

            if(responseCode == HttpURLConnection.HTTP_OK){
                server_response = readStream(urlConnection.getInputStream());
                Log.d(TAG, server_response);
            }

        } catch (MalformedURLException e) {
            Log.e(TAG, e.getMessage());
        } catch (IOException e) {
            Log.e(TAG, e.getMessage());
        }

        return null;
    }

    @Override
    protected void onPostExecute(List<Episode> episodes) {
        super.onPostExecute(episodes);
        callback.onDataReady(episodes);
    }

    // Converting InputStream to String
    private String readStream(InputStream in) {
        BufferedReader reader = null;
        StringBuffer response = new StringBuffer();
        try {
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return response.toString();
    }
}
