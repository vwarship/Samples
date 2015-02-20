package com.zaoqibu.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        TextView tvBluetoothState = (TextView)findViewById(R.id.tvBluetoothState);
        tvBluetoothState.setText(bluetoothAdapter.isEnabled() ? "On" : "Off");

        TextView tvAddress = (TextView)findViewById(R.id.tvAddress);
        tvAddress.setText(bluetoothAdapter.getAddress());

        if (bluetoothAdapter.isEnabled()) {
            TextView tvName = (TextView)findViewById(R.id.tvName);
            tvName.setText(bluetoothAdapter.getName());
        }
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
