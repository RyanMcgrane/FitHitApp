package com.example.ryanm.finalgymapp;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity
{
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;

    Button button_back;
    Button button_login;

    EditText txtEmail;
    EditText txtPassword;

    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        openHelper = new DatabaseHelper(this);
        db = openHelper.getReadableDatabase();

        button_back = (Button) findViewById(R.id.button_back);
        button_login = (Button) findViewById(R.id.button_login);

        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtPassword = (EditText) findViewById(R.id.txtPassword);

        button_login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String Email = txtEmail.getText().toString();
                String Password = txtPassword.getText().toString();
                cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_NAME + " WHERE " + DatabaseHelper.COL_5 + "=? AND " + DatabaseHelper.COL_4 + "=? ", new String[] {Email, Password} );

                if(cursor != null)
                {
                    if(cursor.getCount() > 0)
                    {
                        cursor.moveToNext();
                        Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_LONG).show();


                        //Change intent to the main menu screen
                        Intent intent = new Intent(getApplicationContext(), MainMenu.class);
                        startActivity(intent);
                    }

                    else
                    {
                        Toast.makeText(getApplicationContext(), "Unsuccessful - ERROR", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });


        button_back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class );
                startActivity(intent);
            }
        });
    }
}
