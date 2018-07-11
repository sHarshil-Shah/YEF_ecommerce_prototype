package com.example.sum.e_commerce;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("Main", "In Main Activity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.ic_launcher_round);

        itemDetails john = new itemDetails("item 1","desc 1",1000,R.drawable.image1);
        itemDetails steve = new itemDetails("item 2","desc 2",2000,R.drawable.image2);
        itemDetails stacy = new itemDetails("item 3","desc 3",3000,R.drawable.image3);
        itemDetails ashley = new itemDetails("item 4","desc 4",4000,R.drawable.image4);

        ArrayList<itemDetails> peopleList = new ArrayList<>();
        peopleList.add(john);
        peopleList.add(steve);
        peopleList.add(stacy);
        peopleList.add(ashley);

        ListAdapter adapter = new CustomAdapter(this, R.layout.custom_row, peopleList);
        ListView listView = findViewById(R.id.itemsList);
        listView.setAdapter(adapter);

        //ListAdapter listAdapter = new CustomAdapter(this, items);

        //listView.setAdapter(listAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent myIntent = new Intent(MainActivity.this, details.class);
                myIntent.putExtra("i", i);
                startActivity(myIntent);
            }
        });
    }
}
