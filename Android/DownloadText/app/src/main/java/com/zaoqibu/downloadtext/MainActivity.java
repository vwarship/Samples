package com.zaoqibu.downloadtext;

import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new downloadTextTask().execute(makeURLStringWithGitHub("text.txt"));
    }

    private String makeURLStringWithGitHub(String filename) {
        String gitHubURLFormat = "https://raw.githubusercontent.com/vwarship/Samples/master/Android/DownloadText/%s";
        return String.format(gitHubURLFormat, filename);
    }

    private class downloadTextTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            return downloadText(params[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            TextView textView = (TextView)findViewById(R.id.textView);
            textView.setText(s);
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

    private String downloadText(String urlString) {
        StringBuilder sb = new StringBuilder();

        final int BUF_SIZE = 4096;
        char[] buf = new char[BUF_SIZE];
        int readedLen = 0;

        try {
            InputStream inputStream = openHttpConnection(urlString);
            InputStreamReader reader = new InputStreamReader(inputStream);

            while ((readedLen = reader.read(buf)) > 0) {
                sb.append(new String(buf, 0, readedLen));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
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
