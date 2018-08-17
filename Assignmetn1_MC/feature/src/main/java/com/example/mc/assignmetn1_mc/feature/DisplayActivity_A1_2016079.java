package com.example.mc.assignmetn1_mc.feature;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayActivity_A1_2016079 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display__a1_2016079);

        Intent intent = getIntent();
        Bundle messages = intent.getExtras();


        String name = messages.getString("NAME");
        String rollno = messages.getString("ROLL_NO");
        String branch = messages.getString("BRANCH");
        String course1 = messages.getString("COURSE1");
        String course2 = messages.getString("COURSE2");
        String course3 = messages.getString("COURSE3");
        String course4 = messages.getString("COURSE4");

        TextView txtname = findViewById(R.id.txtname);
        TextView txtrollno = findViewById(R.id.txtrollno);
        TextView txtbranch = findViewById(R.id.txtbranch);
        TextView txtcourse1 = findViewById(R.id.txtcourse1);
        TextView txtcourse2 = findViewById(R.id.txtcourse2);
        TextView txtcourse3 = findViewById(R.id.txtcourse3);
        TextView txtcourse4 = findViewById(R.id.txtcourse4);

        txtname.setText(name);
        txtrollno.setText(rollno);
        txtbranch.setText(branch);
        txtcourse1.setText(course1);
        txtcourse2.setText(course2);
        txtcourse3.setText(course3);
        txtcourse4.setText(course4);




    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("App", "State of activity DisplayActivity started");
        Toast.makeText(DisplayActivity_A1_2016079.this,"State of activity DisplayActivity started" , Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("App", "State of activity DisplayActivity changed from Paused to Resumed");
        Toast.makeText(DisplayActivity_A1_2016079.this,"State of activity DisplayActivity changed from Paused to Resumed" , Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("App", "State of activity DisplayActivity changed from Resumed to Paused");
        Toast.makeText(DisplayActivity_A1_2016079.this,"State of activity DisplayActivity changed from Resumed to Paused" , Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("App", "State of activity DisplayActivity stopped");
        Toast.makeText(DisplayActivity_A1_2016079.this,"State of activity DisplayActivity stopped" , Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("App", "State of activity DisplayActivity restarted");
        Toast.makeText(DisplayActivity_A1_2016079.this,"State of activity DisplayActivity restarted" , Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("App", "State of activity DisplayActivity destroyed");
        Toast.makeText(DisplayActivity_A1_2016079.this,"State of activity DisplayActivity destroyed" , Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("App", "onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i("App", "onRestoreInstanceState");
    }
}
