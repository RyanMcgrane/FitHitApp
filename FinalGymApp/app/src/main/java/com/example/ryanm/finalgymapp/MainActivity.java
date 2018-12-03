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


public class MainActivity extends Activity
{
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;

    Button button_reg;
    Button button_login;
    EditText txtFirstName;
    EditText txtLastName;
    EditText txtPassword;
    EditText txtEmail;
    EditText txtPhoneNo;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openHelper = new DatabaseHelper(this);


        button_reg = (Button) findViewById(R.id.button_reg);
        button_login = (Button) findViewById(R.id.button_login);

        txtFirstName = (EditText) findViewById(R.id.txtFirstName);
        txtLastName = (EditText) findViewById(R.id.txtLastName);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtPhoneNo = (EditText) findViewById(R.id.txtPhoneNo);

        button_reg.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                db = openHelper.getWritableDatabase();
                String FirstName = txtFirstName.getText().toString();
                String LastName = txtLastName.getText().toString();
                String Password = txtPassword.getText().toString();
                String Email = txtEmail.getText().toString();
                String PhoneNo = txtPhoneNo.getText().toString();

                InsertData(FirstName, LastName, Password, Email, PhoneNo);

                Toast.makeText(getApplicationContext(),"Register Was Successful", Toast.LENGTH_LONG).show();
            }


        });

        button_login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });

    }

    public void InsertData(String FirstName, String LastName, String Password, String Email, String PhoneNo)
    {
        ContentValues contentValues = new ContentValues();

        contentValues.put(DatabaseHelper.COL_2, FirstName);
        contentValues.put(DatabaseHelper.COL_3, LastName);
        contentValues.put(DatabaseHelper.COL_4, Password);
        contentValues.put(DatabaseHelper.COL_5, Email);
        contentValues.put(DatabaseHelper.COL_6, PhoneNo);

        long id = db.insert(DatabaseHelper.TABLE_NAME, null, contentValues);
    }


}
