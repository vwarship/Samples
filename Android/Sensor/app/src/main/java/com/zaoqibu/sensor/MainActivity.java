package com.zaoqibu.sensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.List;


public class MainActivity extends ActionBarActivity {
    private static final String TAG = "MainActivity";
    private SensorManager sensorManager = null;
    private SensorEventListener accelerometerSensorEventListener = null;

    private class AccelerometerSensorEventListener implements SensorEventListener {
        @Override
        public void onSensorChanged(SensorEvent event) {
            Log.i(TAG, String.format("x:%f, y:%f, z:%f", event.values[0], event.values[1], event.values[2]));
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        accelerometerSensorEventListener = new AccelerometerSensorEventListener();

        List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);

        int i = 1;
        StringBuilder sb = new StringBuilder();
        for (Sensor sensor : sensors) {
            sb.append(String.format("%d) 名字: %s\n", i++, sensor.getName()))
              .append(String.format("\t供应商: %s\n", sensor.getVendor()))
              .append(String.format("\t电量: %f\n", sensor.getPower()))
              .append(String.format("\tMinDelay: %d\n", sensor.getMinDelay()))
              .append(String.format("\tMaximumRange: %f\n", sensor.getMaximumRange()))
              .append(String.format("\tResolution: %f\n", sensor.getResolution()));
        }

        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText(sb.toString());

        Log.i("examples", sb.toString());
    }

    @Override
    protected void onResume() {
        super.onResume();

        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(accelerometerSensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();

        sensorManager.unregisterListener(accelerometerSensorEventListener);
    }

}
