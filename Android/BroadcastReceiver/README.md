## 应用内注册短信接收器

### RouteBroadcastReceiver.java
```java
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
```
* 继承 BroadcastReceiver 类，重写 onReceive 方法。
* 从 intent 中读取 pdus，如果一条短信超过160字，会有多个 Object 对象。
* 调用 SmsMessage 的 getOriginatingAddress 方法获得发送的号码，getMessageBody 方法获得短信内容。
* abortBroadcast 方法可以中断消息断续传播，其它应用将不会收到这条短信（包括短信应用）。

### MainActivity.java
```java
public class MainActivity extends ActionBarActivity {
    private RouteBroadcastReceiver routeBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        routeBroadcastReceiver = new RouteBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
        registerReceiver(routeBroadcastReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        unregisterReceiver(routeBroadcastReceiver);
        super.onPause();
    }
}
```
* 在 onResume 方法内注册 registerReceiver。需要使用意图过滤器指定接收短信的活动 android.provider.Telephony.SMS_RECEIVED。
* 在 onPause 方法内取消 unregisterReceiver。

### AndroidManifest.xml
```xml
<uses-permission android:name="android.permission.RECEIVE_SMS"/>
```
*增加接收短信的权限
