package com.zaoqibu.fragmentlifecycle;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;


public class MainActivity extends ActionBarActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate Enter");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate Leave");
    }

    @Override
    protected void onStart() {
        Log.i(TAG, "onStart Enter");
        super.onStart();
        Log.i(TAG, "onStart Leave");
    }

    @Override
    protected void onRestart() {
        Log.i(TAG, "onRestart Enter");
        super.onRestart();
        Log.i(TAG, "onRestart Leave");
    }

    @Override
    protected void onResume() {
        Log.i(TAG, "onResume Enter");
        super.onResume();
        Log.i(TAG, "onResume Leave");
    }

    @Override
    protected void onPause() {
        Log.i(TAG, "onPause Enter");
        super.onPause();
        Log.i(TAG, "onPause Leave");
    }

    @Override
    protected void onStop() {
        Log.i(TAG, "onStop Enter");
        super.onStop();
        Log.i(TAG, "onStop Leave");
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, "onDestroy Enter");
        super.onDestroy();
        Log.i(TAG, "onDestroy Leave");
    }

}
