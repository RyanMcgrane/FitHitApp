package com.example.ryanm.finalgymapp;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MyProfile extends Activity
{

    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;

    Button button_save;
    EditText txtAge;
    EditText txtWeight;
    EditText txtHeight;
    EditText txtBMI;
    EditText txtBodyFat;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        openHelper = new DatabaseHelper(this);

        button_save = (Button) findViewById(R.id.save);

        txtAge = (EditText) findViewById(R.id.age);
        txtWeight = (EditText) findViewById(R.id.weight);
        txtHeight = (EditText) findViewById(R.id.height);
        txtBMI = (EditText) findViewById(R.id.bmi);
        txtBodyFat = (EditText) findViewById(R.id.body_fat);


        button_save.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                db = openHelper.getWritableDatabase();
                String Age = txtAge.getText().toString();
                String Weight = txtWeight.getText().toString();
                String Height = txtHeight.getText().toString();
                String BMI = txtBMI.getText().toString();
                String BodyFat = txtBodyFat.getText().toString();


                InsertData(Age, Weight, Height, BMI, BodyFat);

                Toast.makeText(getApplicationContext(),"Save Successful", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), update.class);
                startActivity(intent);
            }
        });

    }

    public void InsertData(String Age, String Weight, String Height, String BMI, String BodyFat)
    {
        ContentValues contentValues = new ContentValues();

        contentValues.put(DatabaseHelper.COLUMN_2, Age);
        contentValues.put(DatabaseHelper.COLUMN_3, Weight);
        contentValues.put(DatabaseHelper.COLUMN_4, Height);
        contentValues.put(DatabaseHelper.COLUMN_5, BMI);
        contentValues.put(DatabaseHelper.COLUMN_6, BodyFat);

        long id = db.insert(DatabaseHelper.TABLE_NAMED, null, contentValues);
    }


}
