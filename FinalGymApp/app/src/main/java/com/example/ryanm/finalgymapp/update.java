package com.example.ryanm.finalgymapp;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.os.Build.ID;
import static com.example.ryanm.finalgymapp.DatabaseHelper.COLUMN_2;
import static com.example.ryanm.finalgymapp.DatabaseHelper.COLUMN_3;
import static com.example.ryanm.finalgymapp.DatabaseHelper.COLUMN_4;
import static com.example.ryanm.finalgymapp.DatabaseHelper.COLUMN_5;
import static com.example.ryanm.finalgymapp.DatabaseHelper.COLUMN_6;
import static com.example.ryanm.finalgymapp.DatabaseHelper.TABLE_NAMED;

public class update extends Activity
{

    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;

    Button button1;
    Button button2;
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        openHelper = new DatabaseHelper(this);


        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);



        /*
        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                db = openHelper.getWritableDatabase();
                String Age = txtAge.getText().toString();
                String Weight = txtLastName.getText().toString();
                String Height = txtPassword.getText().toString();
                String BMI = txtEmail.getText().toString();
                String BodyFat = txtPhoneNo.getText().toString();
            }
        });
        */


        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(getApplicationContext(),"Needs to be implemented!!", Toast.LENGTH_LONG).show();
            }
        });

        button3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

            }
        });
    }


    public long insertInformation(int Age, float Weight, float Height, float BMI, float BodyFat)
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(COLUMN_2, Age);
        initialValues.put(COLUMN_3, Weight);
        initialValues.put(COLUMN_4, Height);
        initialValues.put(COLUMN_5, BMI);
        initialValues.put(COLUMN_6, BodyFat);
        return db.insert(TABLE_NAMED, null, initialValues);
    }

    public boolean deletePerson(long rowId)
    {
        //
        return db.delete(TABLE_NAMED, ID +
                "=" + ID, null) > 0;
    }

    /*
    public void addInformation (View view)
    {
        startActivity(new Intent(getApplicationContext(),MyProfile.class));
    }
    */


    /*public void displayInformation (View view)
    {
        startActivity(new Intent(getApplicationContext(),DisplayInfo.class));
    }
    */
}
