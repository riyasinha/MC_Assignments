package com.example.mc.assignment3_mc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import java.io.Serializable;
import java.util.ArrayList;

public class ResponseDatabase extends SQLiteOpenHelper implements Serializable{

    Context context;
    static final String name = "App_Database";
    static final String tablename = "Response_Table";
    static final int database_version = 1;
    static final String query = "create table "+tablename+"(questionnumber INTEGER PRIMARY KEY AUTOINCREMENT, question TEXT, answer TEXT)";
    public static ArrayList<QuizQuestion> quiz_arr;
    public ResponseDatabase(Context context)
    {
        super(context, name, null, database_version);
        this.context = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(query);
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("Lima is the capital of Peru");
        arr.add("Riyadh is the capital of UAE");
        arr.add("Rio de Janeiro is the capital of Brazil");
        arr.add("Mumbai is the capital of India");
        arr.add("Dublin is the capital of Ireland");
        arr.add("London is the capital of England");
        arr.add("Thimpu is the capital of Nepal");
        arr.add("Doha is the capital of Qatar");
        arr.add("New York is the capital of the United States of America");
        arr.add("Brasilia is the capital of Brazil");
        arr.add("Berne is the capital of Austria");
        arr.add("Tbilisi is the capital of Georgia");
        arr.add("Yangoon is the capital of Singapore");
        arr.add("Kaula Lampur is the capital of Malaysia");
        arr.add("Pattaya is the capital of Thailand");
        arr.add("Rio de Janeiro is the capital of Uzbekistan");
        arr.add("Kiev is the capital of Ukraine");
        arr.add("Ontario is the capital of Canada");
        arr.add("Canberra is the capital of Australia");
        arr.add("Melbourne is the capital of New Zealand");
        arr.add("Tashkent is the capital of Egypt");
        arr.add("Equador is the capital of South Africa");
        arr.add("Addis Ababa is the capital of Ethiopia");
        arr.add("Karachi is the capital of Pakistan");
        arr.add("Kabul is the capital of Afghanistan");
        arr.add("Frankfurt is the capital of Germany");
        arr.add("Paris is the capital of France");
        arr.add("Moscow is the capital of Poland");
        arr.add("Dodoma is the capital of Tanzania");
        arr.add("Rio de Janeiro is the capital of Argentina");
        for(int i = 0; i<30;i++)
        {
            ContentValues cv = new ContentValues();
            cv.put("question", arr.get(i));
            cv.put("answer", "false");
            db.insert(tablename,null,cv);
        }

    }

    public ArrayList<QuizQuestion> getQuiz_arr() {
        ArrayList<QuizQuestion> arr = new ArrayList<>();
        SQLiteDatabase db  = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+tablename, null);
        if(cursor.moveToFirst())
        {
            do {
                QuizQuestion q = new QuizQuestion(cursor.getString(1), cursor.getString(2),cursor.getInt(0));
                arr.add(q);
            }
            while(cursor.moveToNext());
        }
        return arr;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ tablename);
        onCreate(db);
    }

    public void editresponse(String question, String answer, int questionnumber)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv =new ContentValues();
        cv.put("questionnumber", questionnumber);
        cv.put("quesiton", question);
        cv.put("answer",answer);
        db.update(tablename,cv,"questionnumber"+questionnumber, new String[]{});
    }
}
