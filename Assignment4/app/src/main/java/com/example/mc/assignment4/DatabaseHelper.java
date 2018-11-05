package com.example.mc.assignment4;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import java.io.Serializable;
import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    Context context;
    static final String name = "App_Database";
    static final String accelerometer = "Accelerometer";
    static final String gyroscope = "Gyroscope";
    static final String orientations = "Orientation";
    static final String proximity = "Proximity";
    static final String gps = "GPS";

    static final String col0 = "Timestamp";
    static final String col1 = "SerialNo";
    static final String col2 = "val1";
    static final String col3 = "val2";
    static final String col4 = "val3";

    static final int database_version = 1;
    static final String query1 = "create table "+accelerometer+"("+col1 + " INTEGER PRIMARY KEY AUTOINCREMENT, "+col0+" TEXT, "+col2+" DECIMAL, "+col3+" DECIMAL, "+ col4 +" DECIMAL)";
    static final String query2 = "create table "+gyroscope+"("+col1 + " INTEGER PRIMARY KEY AUTOINCREMENT"+", "+col0+" TEXT,"+col2+" DECIMAL,"+col3+" DECIMAL,"+ col4 +" DECIMAL)";
    static final String query3 = "create table "+proximity+"("+col1 + " INTEGER PRIMARY KEY AUTOINCREMENT"+", "+col0+" TEXT,"+col2+" DECIMAL,"+col3+" DECIMAL,"+ col4 +" DECIMAL)";
    static final String query4 = "create table "+orientations+"("+col1 + " INTEGER PRIMARY KEY AUTOINCREMENT"+", "+col0+" TEXT,"+col2+" DECIMAL,"+col3+" DECIMAL,"+ col4 +" DECIMAL)";
    static final String query5 = "create table "+gps+"("+col1 + " INTEGER PRIMARY KEY AUTOINCREMENT"+", "+col0+" TEXT,"+col2+" DECIMAL,"+col3+" DECIMAL,"+ col4 +" DECIMAL)";

    public DatabaseHelper(Context context)
    {
        super(context, name, null, database_version);
        this.context = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(query1);
        db.execSQL(query2);
        db.execSQL(query3);
        db.execSQL(query4);
        db.execSQL(query5);




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i2) {
        db.execSQL("DROP TABLE IF EXISTS "+ accelerometer);
        db.execSQL("DROP TABLE IF EXISTS "+ gyroscope);
        db.execSQL("DROP TABLE IF EXISTS "+ gps);
        db.execSQL("DROP TABLE IF EXISTS "+ proximity);
        db.execSQL("DROP TABLE IF EXISTS "+ accelerometer);



        onCreate(db);
    }

    public void add_acc(String s , float a, float b , float c)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(col0, s);
        cv.put(col2, a);
        cv.put(col3, b);
        cv.put(col4, c);
        db.insert(accelerometer,null,cv);
        db.close();

    }

    public void add_gyr(String s , float a, float b , float c)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(col0, s);
        cv.put(col2, a);
        cv.put(col3, b);
        cv.put(col4, c);db.insert(gyroscope,null,cv);
        db.close();

    }
    public void add_ori(String s , float a, float b , float c)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(col0, s);
        cv.put(col2, a);
        cv.put(col3, b);
        cv.put(col4, c);db.insert(orientations,null,cv);
        db.close();

    }
    public void add_gps(String s , double a, double b)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(col0, s);
        cv.put(col2, a);
        cv.put(col3, b);
        db.insert(gps,null,cv);
        db.close();

    }

    public void add_proximity(String s , float a)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(col0, s);
        cv.put(col2, a);

        db.insert(proximity,null,cv);
        db.close();

    }
}
