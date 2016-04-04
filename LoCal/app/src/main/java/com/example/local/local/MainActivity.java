package com.example.local.local;

import android.app.Activity;
import android.app.usage.UsageEvents;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import java.util.*;
import android.widget.*;
import android.widget.TextView;
import android.content.Intent;
import android.view.*;


public class MainActivity extends AppCompatActivity {

    private ArrayList<String> eventList = new ArrayList<>();
    private ListView calendarView;
    private StableArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendarView = (ListView) findViewById(R.id.calendarView);


        String[] events = new String[]{"Mobile Applications Development", "Artificial Intelligence",
        "Psychology", "Lunch", "Dinner", "TV", "Other stuff", "Homework", "Work on Calendar", "Brush Teeth", "Get Pillow", "Go to sleep"};

        for(int i = 0; i<events.length; i++){
            eventList.add(events[i]);
        }

        adapter = new StableArrayAdapter(this,
                android.R.layout.simple_list_item_1, eventList);

        calendarView.setAdapter(adapter);

        final ArrayList<String> DaysOfWeek = new ArrayList<String>();
        String[] days = new String[]{"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        for(int i = 0; i < days.length; i++){
            DaysOfWeek.add(days[i]);
        }

    }

    public void onSaveInstanceState(Bundle savedInstanceState){

    }

    public void addEvent(View view){
        Intent intent = new Intent(this, AddEventActivity.class);
        startActivityForResult(intent,2);
    }

    public void addLocation(View view){
        Intent intent = new Intent(this, AddLocationActivity.class);
        startActivityForResult(intent, 3);
    }

//    @Override
//    public void onResume(){
//        super.onResume();
//
//        adapter = new StableArrayAdapter(this,
//                android.R.layout.simple_list_item_1, eventList);
//        Log.d("onResume",eventList.get(eventList.size() - 1));
//        calendarView.setAdapter(adapter);
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("onActivityResult","in function");
        if (requestCode == 2) {
            Log.d("onActivityResult","inside request");
            if (resultCode == RESULT_OK) {
                Log.d("onActivityResult","inside result");
                String myValue = data.getStringExtra("eventName");
                Log.d("onActivityResult",myValue);
                eventList.add(myValue);
                adapter = new StableArrayAdapter(this, android.R.layout.simple_list_item_1,eventList);
                calendarView.setAdapter(adapter);            }
        }
    }

}
