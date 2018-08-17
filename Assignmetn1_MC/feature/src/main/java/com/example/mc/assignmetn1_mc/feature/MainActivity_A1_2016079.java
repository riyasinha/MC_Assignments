package com.example.mc.assignmetn1_mc.feature;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity_A1_2016079 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__a1_2016079);
    }

    public void SendData(View view)
    {
        Intent intent =  new Intent(this, DisplayActivity_A1_2016079.class);
        EditText name = (EditText) findViewById(R.id.etname);
        EditText rollno = (EditText) findViewById(R.id.etrollno);
        EditText branch = (EditText) findViewById(R.id.etbranch);
        EditText course1 = (EditText) findViewById(R.id.etcourse1);
        EditText course2  = (EditText) findViewById(R.id.etcourse2);
        EditText course3 = (EditText) findViewById(R.id.etcourse3);
        EditText course4 = (EditText) findViewById(R.id.etcourse4);

        String msgname = name.getText().toString();
        String msgrollno = rollno.getText().toString();
        String msgbranch = branch.getText().toString();
        String msgcourse1 = course1.getText().toString();
        String msgcourse2 = course2.getText().toString();
        String msgcourse3 = course3.getText().toString();
        String msgcourse4 = course4.getText().toString();

            Bundle messages = new Bundle();

            messages.putString("NAME", msgname);
            messages.putString("ROLL_NO",msgrollno);
            messages.putString("BRANCH",msgbranch);
            messages.putString("COURSE1",msgcourse1);
            messages.putString("COURSE2",msgcourse2);
            messages.putString("COURSE3",msgcourse3);
            messages.putString("COURSE4",msgcourse4);

            intent.putExtras(messages);

            startActivity(intent);


        }

        public void ClearData(View view){

            EditText name = (EditText) findViewById(R.id.etname);
            EditText rollno = (EditText) findViewById(R.id.etrollno);
            EditText branch = (EditText) findViewById(R.id.etbranch);
            EditText course1 = (EditText) findViewById(R.id.etcourse1);
            EditText course2  = (EditText) findViewById(R.id.etcourse2);
            EditText course3 = (EditText) findViewById(R.id.etcourse3);
            EditText course4 = (EditText) findViewById(R.id.etcourse4);

            name.setText("");
            rollno.setText("");
            branch.setText("");
            course1.setText("");
            course2.setText("");
            course3.setText("");
            course4.setText("");



        }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("App", "State of activity MainActivity started");
        Toast.makeText(MainActivity_A1_2016079.this,"State of activity MainActivity started" , Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("App", "State of activity MainActivity changed from Paused to Resumed");
        Toast.makeText(MainActivity_A1_2016079.this,"State of activity MainActivity changed from Paused to Resumed" , Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("App", "State of activity MainActivity changed from Resumed to Paused");
        Toast.makeText(MainActivity_A1_2016079.this,"State of activity MainActivity changed from Resumed to Paused" , Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("App", "State of activity MainActivity stopped");
        Toast.makeText(MainActivity_A1_2016079.this,"State of activity MainActivity stopped" , Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("App", "State of activity MainActivity restarted");
        Toast.makeText(MainActivity_A1_2016079.this,"State of activity MainActivity restarted" , Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("App", "State of activity MainActivity destroyed");
        Toast.makeText(MainActivity_A1_2016079.this,"State of activity MainActivity destroyed" , Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("App", "onSaveInstanceState");
       // Toast.makeText(MainActivity_A1_2016079.this,"State of activity MainActivity started" , Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i("App", "onRestoreInstanceState");
        //Toast.makeText(MainActivity_A1_2016079.this,"State of activity MainActivity started" , Toast.LENGTH_SHORT).show();

    }

    }


