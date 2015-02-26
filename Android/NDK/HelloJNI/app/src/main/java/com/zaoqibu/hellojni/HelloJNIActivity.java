package com.zaoqibu.hellojni;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;


public class HelloJNIActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hellojni);

        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText(stringFromJNI());
    }

    public native String  stringFromJNI();

    static {
        System.loadLibrary("hello-jni");
    }

}
