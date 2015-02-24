package com.zaoqibu.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.telephony.SmsMessage;

/**
 * Created by vwarship on 2015/2/24.
 */
public class RouteBroadcastReceiver extends BroadcastReceiver {
    private Handler handler;

    public RouteBroadcastReceiver(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void onReceive(final Context context, Intent intent) {
        if (intent == null)
            return;

        final StringBuilder sb = new StringBuilder();

        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            Object[] msgs = (Object[])bundle.get("pdus");

            for (Object msg : msgs) {
                SmsMessage smsMessage = SmsMessage.createFromPdu((byte[])msg);
                sb.append(smsMessage.getMessageBody());
            }
        }

        Bundle smsBundle = new Bundle();
        smsBundle.putString("SMS", sb.toString());
        Message message = new Message();
        message.setData(smsBundle);
        handler.sendMessage(message);

        abortBroadcast();
    }
}
