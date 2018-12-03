package com.example.ryanm.finalgymapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainMenu extends Activity
{

    int[] IMAGES = { R.drawable.myprofile, R.drawable.strength, R.drawable.running, R.drawable.nutrition,
            R.drawable.gymsnearme };



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        ListView listView = (ListView) findViewById(R.id.listView);

        CustomAdapter customAdapter = new CustomAdapter();

        listView.setAdapter(customAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                if(i == 0)
                {
                    Intent intent = new Intent(getApplicationContext(), MyProfile.class);
                    startActivity(intent);
                }
                if(i == 4)
                {
                    Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                    startActivity(intent);
                }
            }
        });


      /*  final ArrayList<String> options = new ArrayList<String>();

        options.add("Strength Exercises");
        options.add("Stretches");
        options.add("Cardio");
        options.add("Meals");
        options.add("Gyms Near Me");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, options );

        listView.setAdapter(arrayAdapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {


                if(i == 4)
                {
                    Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                    intent.putExtra("Option", options.get(i));
                    startActivity(intent);
                }

            }
        });
        */
    }


    class CustomAdapter extends BaseAdapter
    {

        @Override
        public int getCount() {
            return IMAGES.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup)
        {

            view = getLayoutInflater().inflate(R.layout.customlayout,null);

            ImageView imageView = (ImageView) view.findViewById(R.id.imageView);

            imageView.setImageResource(IMAGES[i]);

            return view;
        }


    }

}
