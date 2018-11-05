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
import android.widget.Toast;

public class AccelerometerActivity extends Activity implements SensorEventListener{

    private TextView xtext;
    private TextView ytext;
    private TextView ztext;
    private DatabaseHelper db;
    float accfinal;
    float accvalue;
    float shake;
    Button start;
    Button stop;

    private Sensor sensor;
    private SensorManager sensorManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);

        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);


        xtext = (TextView)findViewById(R.id.xText);
        ytext = (TextView)findViewById(R.id.yText);
        ztext = (TextView)findViewById(R.id.zText);
        start = (Button)findViewById(R.id.button);
        stop = (Button)findViewById(R.id.button2);
        db = new DatabaseHelper(this);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sensorManager.registerListener(AccelerometerActivity.this, sensor, sensorManager.SENSOR_DELAY_NORMAL);
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sensorManager.flush(AccelerometerActivity.this);
                sensorManager.unregisterListener(AccelerometerActivity.this);
            }
        });



    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];

        accfinal = accvalue;
        accvalue = (float)Math.sqrt(x*x +y*y+z*z);

        float diff = accvalue-accfinal;


        shake = shake*0.9f + diff;

        if(shake>12)
        {

            Toast toast  = Toast.makeText(getApplicationContext(),"Phone has been shaken", Toast.LENGTH_SHORT);
            toast.show();
        }

        xtext.setText("X-AXIS: "+ event.values[0]);
        Log.i("x-axis: ", String.valueOf(event.values[0]));
        ytext.setText("Y-AXIS: "+ event.values[1]);
        Log.i("-yaxis: ", String.valueOf(event.values[1]));
        ztext.setText("Z-AXIS: "+ event.values[2]);
        Log.i("z-axis: ", String.valueOf(event.values[2]));

        db.add_acc(event.timestamp+"", event.values[0], event.values[1],event.values[2]);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }


}
