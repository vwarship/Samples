package com.zaoqibu.createservice;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.util.List;

public class MyService extends Service {
    private IBinder binder = new MyBinder();

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    class MyBinder extends Binder {
        MyService getService() {
            return MyService.this;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();

        ActivityManager activityManager = (ActivityManager)getSystemService(ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> runningAppProcessesInfos = activityManager.getRunningAppProcesses();

        Log.i("test", "runningAppProcess size: " + runningAppProcessesInfos.size());
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcessesInfos) {
            String processName = runningAppProcessInfo.processName;
            Log.i("test", processName);
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);

        return START_STICKY;
    }

}
