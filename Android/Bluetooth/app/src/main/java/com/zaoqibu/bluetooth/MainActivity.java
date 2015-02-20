package com.zaoqibu.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    private BroadcastReceiver bluetoothStateChangeReceiver = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initBluetoothUI();

        bluetoothStateChangeReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                initBluetoothUI();
            }
        };

        registerReceiver(bluetoothStateChangeReceiver, new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED));
    }

    private void initBluetoothUI() {
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
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(bluetoothStateChangeReceiver);
    }
}
