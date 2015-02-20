package com.zaoqibu.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    private BroadcastReceiver bluetoothStateChangeReceiver = null;
    private static final int BLUETOOTH_ENABLE = 1;

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

        Switch switchBluetooth = (Switch)findViewById(R.id.switchBluetooth);
        switchBluetooth.setChecked(bluetoothAdapter.isEnabled());

        TextView tvAddress = (TextView)findViewById(R.id.tvAddress);
        tvAddress.setText(bluetoothAdapter.getAddress());

        if (bluetoothAdapter.isEnabled()) {
            TextView tvName = (TextView)findViewById(R.id.tvName);
            tvName.setText(bluetoothAdapter.getName());
        }
    }

    public void onClickSwitchBluetooth(View view) {
        Switch switchBluetooth = (Switch)findViewById(R.id.switchBluetooth);

        if (switchBluetooth.isChecked()) {
            startActivityForResult(new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE), BLUETOOTH_ENABLE);
        }
        else {
            BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            bluetoothAdapter.disable();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == BLUETOOTH_ENABLE && resultCode == RESULT_OK) {
            initBluetoothUI();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(bluetoothStateChangeReceiver);
    }
}
