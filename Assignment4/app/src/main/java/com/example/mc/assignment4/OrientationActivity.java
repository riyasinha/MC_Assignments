package com.example.mc.assignment4;

import android.graphics.Color;
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

public class OrientationActivity extends Activity implements SensorEventListener{

    private TextView xtext;
    private TextView ytext;
    private TextView ztext;

    Button start;
    Button stop;
    private DatabaseHelper db;
    private Sensor sensor;
    private SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orientation);

        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);

        sensorManager.registerListener(this, sensor,sensorManager.SENSOR_DELAY_NORMAL);
        xtext = (TextView)findViewById(R.id.xText);
        ytext = (TextView)findViewById(R.id.yText);
        ztext = (TextView)findViewById(R.id.zText);

        db = new DatabaseHelper(this);
        start = (Button)findViewById(R.id.button);
        stop = (Button)findViewById(R.id.button2);


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sensorManager.registerListener(OrientationActivity.this, sensor,sensorManager.SENSOR_DELAY_NORMAL);
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sensorManager.flush(OrientationActivity.this);
                sensorManager.unregisterListener(OrientationActivity.this);
            }
        });

    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        float[] rotationMatrix = new float[16];
        SensorManager.getRotationMatrixFromVector(rotationMatrix, event.values);
//        float[] remappedRotationMatrix = new float[16];
//        SensorManager.remapCoordinateSystem(rotationMatrix,
//                SensorManager.AXIS_X,
//                SensorManager.AXIS_Z,
//                remappedRotationMatrix);

// Convert to orientations
        float[] orientations = new float[3];
        SensorManager.getOrientation(rotationMatrix, orientations);

        for(int i = 0; i < 3; i++) {
            orientations[i] = (float)(Math.toDegrees(orientations[i]));
        }


        if(orientations[2] > 45) {
            getWindow().getDecorView().setBackgroundColor(Color.YELLOW);
        } else if(orientations[2] < -45) {
            getWindow().getDecorView().setBackgroundColor(Color.BLUE);
        } else if(Math.abs(orientations[2]) < 10) {
            getWindow().getDecorView().setBackgroundColor(Color.WHITE);
        }
        xtext.setText("X-AXIS: "+ orientations[0]);
        //Log.i("x-axis: ", String.valueOf(event.values[0]));
        ytext.setText("Y-AXIS: "+ orientations[1]);
        //Log.i("-yaxis: ", String.valueOf(event.values[1]));
        ztext.setText("Z-AXIS: "+ orientations[2]);
        //Log.i("z-axis: ", String.valueOf(event.values[2]));

        db.add_ori(event.timestamp+"", event.values[0], event.values[1],event.values[2]);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
