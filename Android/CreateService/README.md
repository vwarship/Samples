## Create Service

1. 创建 Service 类
```java
public class RunningAppProcessService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
```

2. 设置 Service 重启的行为
```java
public class RunningAppProcessService extends Service {
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        return START_STICKY;
    }
}
```

3. 实现 onBind
```java
public class RunningAppProcessService extends Service {
    private IBinder myBinder = new MyBinder();

    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }

    public class MyBinder extends Binder {
        public RunningAppProcessService getService() {
            return RunningAppProcessService.this;
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        return START_STICKY;
    }
}
```

4. 定义 ServiceConnection
```java
public class MainActivity extends ActionBarActivity {
    private RunningAppProcessService runningAppProcessService = null;
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            runningAppProcessService = ((RunningAppProcessService.MyBinder)service).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            runningAppProcessService = null;
        }
    };
}
```

5. 绑定一个服务
```java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        *Intent intent = new Intent(MainActivity.this, RunningAppProcessService.class);
        bindService(intent, serviceConnection, BIND_AUTO_CREATE);*
    }
```