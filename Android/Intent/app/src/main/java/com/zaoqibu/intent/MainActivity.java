package com.zaoqibu.intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;

import org.apache.http.protocol.HTTP;


public class MainActivity extends ActionBarActivity {
    private static final String TAG = "MainActivity";
    private static final int ACTION_LGOIN = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onImplicitStartActivityClick(View view) {
        Intent intent = new Intent(this, HelloActivity.class);
        startActivity(intent);
    }

    public void onExplicitStartActivityClick(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:888888888"));
        startActivity(intent);
    }

    public void onStartActivityForResultClick(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivityForResult(intent, ACTION_LGOIN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ACTION_LGOIN && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();

            Log.i(TAG, extras.get(LoginActivity.EMAIL).toString());
            Log.i(TAG, extras.get(LoginActivity.PASSWORD).toString());
        }
    }
}
