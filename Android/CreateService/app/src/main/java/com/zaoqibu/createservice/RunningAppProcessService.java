package com.zaoqibu.createservice;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Binder;
import android.os.IBinder;

import java.util.ArrayList;
import java.util.List;

public class RunningAppProcessService extends Service {
    private IBinder myBinder = new MyBinder();

    public RunningAppProcessService() {
    }

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
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        return START_STICKY;
    }

    public List<RunningAppProgress> getRunningAppProgresses() {
        List<RunningAppProgress> runningAppProgresses = new ArrayList<RunningAppProgress>();

        ActivityManager activityManager = (ActivityManager)getSystemService(ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> runningAppProcessInfos = activityManager.getRunningAppProcesses();

        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcessInfos) {
            ApplicationInfo applicationInfo = getApplicationInfoByProcessName(runningAppProcessInfo.processName);
            if (applicationInfo != null) {
                String name = applicationInfo.loadLabel(getPackageManager()).toString();
                Drawable icon = applicationInfo.loadIcon(getPackageManager());

                runningAppProgresses.add(new RunningAppProgress(name, icon));
            }
        }

        return runningAppProgresses;
    }

    private ApplicationInfo getApplicationInfoByProcessName(final String processName) {
        PackageManager packageManager = this.getApplicationContext().getPackageManager();
        List<ApplicationInfo> applicationInfos = packageManager.getInstalledApplications(PackageManager.GET_UNINSTALLED_PACKAGES);

        for (ApplicationInfo applicationInfo : applicationInfos) {
            if (processName.equals(applicationInfo.processName))
                return applicationInfo;
        }

        return null;
    }

}
