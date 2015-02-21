package com.zaoqibu.resource;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;


public class ResourceStringTypeActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource_string_type);

        String simpleString = getString(R.string.hello);
        TextView tvSimpleString = (TextView)findViewById(R.id.tvSimpleString);
        tvSimpleString.setText(simpleString);

        String[] stringArray = getResources().getStringArray(R.array.rgb);
        StringBuilder sb = new StringBuilder("String Array: RGB(");
        for (String s : stringArray)
            sb.append(s).append(" ");
        sb.append(")");

        TextView tvStringArray = (TextView)findViewById(R.id.tvStringArray);
        tvStringArray.setText(sb.toString());
    }

}
