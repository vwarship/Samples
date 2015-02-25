package com.zaoqibu.remoteservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import android.util.Log;

public class RemoteService extends Service {
    private static final String TAG = "RemoteService";

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    private final IRemoteService.Stub binder = new IRemoteService.Stub() {
        public int getPid(){
            return Process.myPid();
        }

        public void basicTypes(int anInt, long aLong, boolean aBoolean,
                               float aFloat, double aDouble, String aString) {
            String str = String.format("anInt:%d, aLong:%d, aBoolean:%b, aFloat:%f, aDouble:%f, aString:%s",
                    anInt, aLong, aBoolean, aFloat, aDouble, aString);
            Log.i(TAG, str);
        }
    };

}
