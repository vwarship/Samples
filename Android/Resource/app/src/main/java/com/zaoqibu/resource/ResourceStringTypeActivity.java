package com.zaoqibu.resource;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;


public class ResourceStringTypeActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource_string_type);

        Resources resources = getResources();

        // Simple String
        String simpleString = getString(R.string.hello);
        TextView tvSimpleString = (TextView)findViewById(R.id.tvSimpleString);
        tvSimpleString.setText(simpleString);

        // String Array
        String[] stringArray = resources.getStringArray(R.array.rgb);
        StringBuilder sb = new StringBuilder("String Array: RGB(");
        for (String s : stringArray)
            sb.append(s).append(" ");
        sb.append(")");

        TextView tvStringArray = (TextView)findViewById(R.id.tvStringArray);
        tvStringArray.setText(sb.toString());

        // Quantity Strings(Plurals)
        TextView tvPlurals = (TextView)findViewById(R.id.tvPlurals);
        tvPlurals.setText("Plurals: " + resources.getQuantityString(R.plurals.numberOfSongsAvailable, 1, 1) + "\t" +
                resources.getQuantityString(R.plurals.numberOfSongsAvailable, 10, 10));

        // String Escaping ' "
        TextView tvEscaping = (TextView)findViewById(R.id.tvEscaping);
        tvEscaping.setText(getString(R.string.escaping));
    }

}
