package com.zaoqibu.resource;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickString(View view) {
        Intent intent = new Intent(this, ResourceStringTypeActivity.class);
        startActivity(intent);
    }
}
