package com.zaoqibu.thread;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;


public class MainActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startCounter();
    }

    private void startCounter() {
        Thread thread = new Thread(new Runnable() {
            int i = 0;

            @Override
            public void run() {
                final TextView textView = (TextView)findViewById(R.id.textView);

                while (i < 10) {
                    ++i;
                    Log.i("examples", String.valueOf(i));

                    textView.post(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText(String.valueOf(i));
                        }
                    });

                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
