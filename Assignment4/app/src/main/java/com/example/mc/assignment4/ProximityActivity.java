package com.example.mc.assignment4;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProximityActivity extends Activity implements SensorEventListener{


    private TextView xtext;

    Button start;
    Button stop;

    private Sensor sensor;
    private SensorManager sensorManager;
    private DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximity);


        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        sensorManager.registerListener(this, sensor,sensorManager.SENSOR_DELAY_NORMAL);
        xtext = (TextView)findViewById(R.id.xText);
        db = new DatabaseHelper(this);
        start = (Button)findViewById(R.id.button);
        stop = (Button)findViewById(R.id.button2);


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sensorManager.registerListener(ProximityActivity.this, sensor,sensorManager.SENSOR_DELAY_NORMAL);
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sensorManager.flush(ProximityActivity.this);
                sensorManager.unregisterListener(ProximityActivity.this);
            }
        });
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.values[0]>-4 && event.values[0]<=4)
        {
            xtext.setText("Proximity Value: NEAR" );
        }
        else{
            xtext.setText("Proximity Value: FAR" );
        }

        Log.i("x-axis: ", String.valueOf(event.values[0]));
        db.add_proximity(System.currentTimeMillis()+"", event.values[0]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
