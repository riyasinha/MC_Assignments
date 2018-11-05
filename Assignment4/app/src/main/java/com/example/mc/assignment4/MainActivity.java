package com.example.mc.assignment4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    Button accelerometer;
    Button gyroscope;
    Button gps;
    Button orientations;
    Button proximity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        accelerometer = (Button)findViewById(R.id.btnAccelerometer);
        gyroscope = (Button)findViewById(R.id.btnGyroscope);
        gps = (Button)findViewById(R.id.btnGPS);
        orientations = (Button)findViewById(R.id.btnOrientation);
        proximity = (Button)findViewById(R.id.btnProximity);



    }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnAccelerometer)
        {
            Intent i = new Intent(MainActivity.this, AccelerometerActivity.class);
            startActivity(i);
        }
        if(v.getId()==R.id.btnGPS)
        {
            Intent i = new Intent(MainActivity.this, GPSActivity.class);
            startActivity(i);
        }
        if(v.getId()==R.id.btnGyroscope)
        {
            Intent i = new Intent(MainActivity.this, GyroscopeActivity.class);
            startActivity(i);
        }
        if(v.getId()==R.id.btnOrientation)
        {
            Intent i = new Intent(MainActivity.this, OrientationActivity.class);
            startActivity(i);
        }
        if(v.getId()==R.id.btnProximity)
        {
            Intent i = new Intent(MainActivity.this, ProximityActivity.class);
            startActivity(i);
        }

    }
}
