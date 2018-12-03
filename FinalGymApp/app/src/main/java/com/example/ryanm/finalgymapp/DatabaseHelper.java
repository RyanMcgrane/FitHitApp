package com.example.ryanm.finalgymapp;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper
{

    public static final String DATABASE_NAME = "database.db";
    public static final String TABLE_NAME = "register";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "FirstName";
    public static final String COL_3 = "LastName";
    public static final String COL_4 = "Password";
    public static final String COL_5 = "Email";
    public static final String COL_6 = "PhoneNo";

    private final Context context;


    public static final String TABLE_NAMED = "info";
    public static final String COLUMN_1 = "ID";
    public static final String COLUMN_2 = "Age";
    public static final String COLUMN_3 = "Weight";
    public static final String COLUMN_4 = "Height";
    public static final String COLUMN_5 = "BMI";
    public static final String COLUMN_6 = "BodyFat";




    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, 1);
        this.context = context;

    }


    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL( "CREATE TABLE " +TABLE_NAME+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " + "FirstName TEXT, " + "LastName TEXT, " + "Password TEXT, " +
                "Email TEXT, " + "PhoneNo TEXT)");


        db.execSQL( "CREATE TABLE " +TABLE_NAMED+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " + "Age TEXT, " + "Weight TEXT, " + "Height TEXT, " +
                "BMI TEXT, " + "BodyFat TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1)
    {

        //Dropping older table if it exists
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAMED);
        onCreate(db);
    }




}
