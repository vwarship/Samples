package com.zaoqibu.sqlite;

import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBAdapter dbAdapter = new DBAdapter(this);
        dbAdapter.open();
        dbAdapter.insertContact("wjj", "wjj@163.com");
        long id = dbAdapter.insertContact("gxl", "gxl@163.com");

        Cursor cursor = dbAdapter.getContact(id);

        Toast.makeText(this, String.format("id:%d, name:%s, email:%s",
                cursor.getLong(0), cursor.getString(1), cursor.getString(2)),
                Toast.LENGTH_LONG).show();

        dbAdapter.close();
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
