package com.zaoqibu.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

/**
 * Created by vwarship on 2015/2/24.
 */
public class RouteBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, Intent intent) {
        if (intent == null)
            return;

        final StringBuilder sb = new StringBuilder();

        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            Object[] msgs = (Object[])bundle.get("pdus");

            boolean isFirst = true;
            for (Object msg : msgs) {
                SmsMessage smsMessage = SmsMessage.createFromPdu((byte[])msg);

                if (isFirst) {
                    sb.append("来自：").append(smsMessage.getOriginatingAddress()).append('\n');
                    isFirst = false;
                }
                
                sb.append(smsMessage.getMessageBody());
            }
        }

        Toast.makeText(context, sb.toString(), Toast.LENGTH_LONG).show();

        abortBroadcast();
    }
}
