package com.zaoqibu.thread;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends ActionBarActivity {
    private CounterRunnable counterRunnable = null;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            final int curValue = (int)msg.obj;
            TextView textView = (TextView)findViewById(R.id.textView);
            textView.setText(String.valueOf(curValue));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startCounter();
    }

    private void startCounter() {
        counterRunnable = new CounterRunnable();
        Thread thread = new Thread(counterRunnable);
        thread.start();
    }

    private class CounterRunnable implements Runnable {
        private volatile boolean isCancel = false;
        int i = 0;

        public void cancel() {
            isCancel = true;
        }

        @Override
        public void run() {
//            final TextView textView = (TextView)findViewById(R.id.textView);

            while (!isCancel && i < 10) {
                ++i;
                Log.i("examples", String.valueOf(i));

//                textView.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        textView.setText(String.valueOf(i));
//                    }
//                });
                handler.obtainMessage(0, i).sendToTarget();

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (counterRunnable != null)
            counterRunnable.cancel();
    }
}
