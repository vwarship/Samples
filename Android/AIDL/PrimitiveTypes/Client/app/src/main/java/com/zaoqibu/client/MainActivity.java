package com.zaoqibu.client;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.zaoqibu.remoteservice.IRemoteService;


public class MainActivity extends ActionBarActivity {
    private static final String TAG = "MainActivity";
    private IRemoteService iremoteService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindService(new Intent(IRemoteService.class.getName()), serviceConnection, BIND_AUTO_CREATE);
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        // Called when the connection with the service is established
        public void onServiceConnected(ComponentName className, IBinder service) {
            // Following the example above for an AIDL interface,
            // this gets an instance of the IRemoteInterface, which we can use to call on the service
            iremoteService = IRemoteService.Stub.asInterface(service);
        }

        // Called when the connection with the service disconnects unexpectedly
        public void onServiceDisconnected(ComponentName className) {
            Log.e(TAG, "Service has unexpectedly disconnected");
            iremoteService = null;
        }
    };

    public void onRemoteServiceProcessIDClick(View view) {
        int processID = 0;
        try {
            processID = iremoteService.getPid();

            iremoteService.basicTypes(1, 2, true, 3.3f, 4.4, "hello");
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        TextView remoteServiceProcessID = (TextView)findViewById(R.id.remoteServiceProcessID);
        remoteServiceProcessID.setText(String.valueOf(processID));

//        new AsyncTask<Void, Void, Integer>() {
//            @Override
//            protected Integer doInBackground(Void... params) {
//                int processID = 0;
//                try {
//                    processID = iremoteService.getPid();
//                } catch (RemoteException e) {
//                    e.printStackTrace();
//                }
//
//                return null;
//            }
//
//            @Override
//            protected void onPostExecute(Integer processID) {
//                TextView remoteServiceProcessID = (TextView)findViewById(R.id.remoteServiceProcessID);
//                remoteServiceProcessID.setText(String.valueOf(processID));
//            }
//        }.execute();
    }

}
