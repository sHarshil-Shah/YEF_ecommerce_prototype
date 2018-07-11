package com.example.sum.e_commerce;


import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.ic_launcher_round);

        itemDetails item1 = new itemDetails("item 1","desc 1",1000,R.drawable.image1);
        itemDetails item2 = new itemDetails("item 2","desc 2",2000,R.drawable.image2);
        itemDetails item3 = new itemDetails("item 3","desc 3",3000,R.drawable.image3);
        itemDetails item4 = new itemDetails("item 4","desc 4",4000,R.drawable.image4);

        ArrayList<itemDetails> peopleList = new ArrayList<>();
        peopleList.add(item1);
        peopleList.add(item2);
        peopleList.add(item3);
        peopleList.add(item4);

        ListAdapter adapter = new CustomAdapter(this, R.layout.custom_row, peopleList);
        ListView listView = findViewById(R.id.itemsList);
        listView.setAdapter(adapter);

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
