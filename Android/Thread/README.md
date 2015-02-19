## Thread

### 在主界面布局（activity_main.xml）中增加 TextView。
```xml
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools" android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="@dimen/activity_horizontal_margin"
    tools:context=".MainActivity">

    <TextView android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerVertical="true"
        android:layout_centerHorizontal="true"
         android:id="@+id/textView"
        android:textSize="200sp"/>

</RelativeLayout>
```

### 在 MainActivity 中增加实现代码。
```java
public class MainActivity extends ActionBarActivity {
    private CounterRunnable counterRunnable = null;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            final int curValue = (int)msg.obj;
            TextView textView = (TextView)findViewById(R.id.textView);
            textView.setText(String.valueOf(curValue));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startCounter();
    }

    private void startCounter() {
        counterRunnable = new CounterRunnable();
        Thread thread = new Thread(counterRunnable);
        thread.start();
    }

    private class CounterRunnable implements Runnable {
        private volatile boolean isCancel = false;
        int i = 0;

        public void cancel() {
            isCancel = true;
        }

        @Override
        public void run() {
//            final TextView textView = (TextView)findViewById(R.id.textView);

            while (!isCancel && i < 10) {
                ++i;
                Log.i("examples", String.valueOf(i));

//                textView.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        textView.setText(String.valueOf(i));
//                    }
//                });
                handler.obtainMessage(0, i).sendToTarget();

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (counterRunnable != null)
            counterRunnable.cancel();
    }
}
```

* 实现 Runnable 接口的 CounterRunnable 的计数任务。
* CounterRunnable 中增加了成员变量 isCancel 为了让线程可以正常退出。
* 在 onDestroy 方法中调用计数任务的 cancel 方法，正常退出计数线程。如果不调用此方法，程序的界面虽然关闭了，但线程还在继续执行。
* 使用 Handler 更新UI。

![](snapshots/thread_counter.png)