package com.zaoqibu.usecustomfont;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Typeface tfMinecraft = Typeface.createFromAsset(getAssets(), "fonts/minecraft.ttf");
        Typeface tfHalflife2 = Typeface.createFromAsset(getAssets(), "fonts/halflife2.ttf");

        TextView tvTitle = (TextView)findViewById(R.id.tvTitle);
        tvTitle.setTypeface(tfMinecraft);

        int buttonIds[] = {R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9};
        for (int buttonId : buttonIds)
            setButtonTypeface(buttonId, tfHalflife2);
    }

    private void setButtonTypeface(int resId, Typeface tfHalflife2) {
        Button button = (Button)findViewById(resId);
        button.setTypeface(tfHalflife2);
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
