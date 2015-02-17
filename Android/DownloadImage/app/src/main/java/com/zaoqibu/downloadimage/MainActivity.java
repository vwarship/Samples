package com.zaoqibu.downloadimage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        new DownloadImageTask().execute(makeURLStringWithGitHub("1"));

        new DownloadImagesTask().execute(
                makeURLStringWithGitHub("1"),
                makeURLStringWithGitHub("2"),
                makeURLStringWithGitHub("3"),
                makeURLStringWithGitHub("4"),
                makeURLStringWithGitHub("5"),
                makeURLStringWithGitHub("6"),
                makeURLStringWithGitHub("7"));
    }

    private String makeURLStringWithGitHub(String filename) {
        String gitHubURLFormat = "https://raw.githubusercontent.com/vwarship/Samples/master/Android/DownloadImage/images/%s.jpg";
        return String.format(gitHubURLFormat, filename);
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        @Override
        protected Bitmap doInBackground(String... params) {
            String url = params[0];
            return downloadImage(url);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            ImageView imageView = (ImageView)findViewById(R.id.imageView);
            imageView.setImageBitmap(bitmap);
        }
    }

    private class DownloadImagesTask extends AsyncTask<String, Bitmap, Void> {

        @Override
        protected Void doInBackground(String... params) {
            final int length = params.length;

            for (String urlString : params) {
                Bitmap bitmap = downloadImage(urlString);
                publishProgress(bitmap);

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Bitmap... values) {
            ImageView imageView = (ImageView)findViewById(R.id.imageView);
            imageView.setImageBitmap(values[0]);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
        }
    }

    private InputStream openHttpConnection(String urlString) throws IOException {
        InputStream inputStream = null;

        URL url = new URL(urlString);
        URLConnection urlConnection = url.openConnection();

        HttpURLConnection httpURLConnection = (HttpURLConnection)urlConnection;
        httpURLConnection.setAllowUserInteraction(false);
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setRequestMethod("GET");

        if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            inputStream = httpURLConnection.getInputStream();
        }

        return inputStream;
    }

    private Bitmap downloadImage(String urlString) {
        InputStream inputStream = null;
        try {
            inputStream = openHttpConnection(urlString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  BitmapFactory.decodeStream(inputStream);
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
}
