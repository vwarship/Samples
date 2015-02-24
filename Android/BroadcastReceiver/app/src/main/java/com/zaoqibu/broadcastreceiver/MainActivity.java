package com.zaoqibu.broadcastreceiver;

import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    private RouteBroadcastReceiver routeBroadcastReceiver;

    class RouteHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String sms = msg.getData().getString("SMS");

            TextView tvSMS = (TextView)findViewById(R.id.tvSMS);
            tvSMS.setText(sms);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        routeBroadcastReceiver = new RouteBroadcastReceiver(new RouteHandler());
        IntentFilter intentFilter = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
        registerReceiver(routeBroadcastReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        unregisterReceiver(routeBroadcastReceiver);
        super.onPause();
    }
}
