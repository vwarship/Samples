package com.zaoqibu.asynctask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;


public class MainActivity extends ActionBarActivity {
    final int maxValue = 10;

    private class CounterTask extends AsyncTask<Integer, Integer, Void> {
        @Override
        protected Void doInBackground(Integer... params) {
            int maxValue = params[0];
            for (int i=1; i<=maxValue; ++i) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                publishProgress(i);
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            int curValue = values[0];

            ProgressBar progressBar = (ProgressBar)findViewById(R.id.progressBar);
            progressBar.setProgress(curValue);

            TextView textView = (TextView)findViewById(R.id.textView);
            textView.setText(String.valueOf(curValue*100/maxValue));
        }

        @Override
        protected void onPostExecute(Void aVoid) {

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProgressBar progressBar = (ProgressBar)findViewById(R.id.progressBar);
        progressBar.setMax(maxValue);

        CounterTask counterTask = new CounterTask();
        counterTask.execute(maxValue);
    }
}
