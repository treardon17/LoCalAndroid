package com.example.local.local;

import android.app.usage.UsageEvents;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.*;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private class StableArrayAdapter extends ArrayAdapter<String> {

        HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

        public StableArrayAdapter(Context context, int textViewResourceId,
                                  List<String> objects) {
            super(context, textViewResourceId, objects);
            for (int i = 0; i < objects.size(); ++i) {
                mIdMap.put(objects.get(i), i);
            }
        }

        @Override
        public long getItemId(int position) {
            String item = getItem(position);
            return mIdMap.get(item);
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView calendarView = (ListView) findViewById(R.id.calendarView);

        String[] events = new String[]{"Mobile Applications Development", "Artificial Intelligence",
        "Psychology", "Lunch", "Dinner"};

        final ArrayList<String> EventsList = new ArrayList<String>();
        for(int i = 0; i < events.length; i++){
            EventsList.add(events[i]);
        }

        final StableArrayAdapter adapter = new StableArrayAdapter(this,
                android.R.layout.simple_list_item_1, EventsList);
        calendarView.setAdapter(adapter);

        final ArrayList<String> DaysOfWeek = new ArrayList<String>();
        String[] days = new String[]{"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        for(int i = 0; i < days.length; i++){
            DaysOfWeek.add(days[i]);
        }
        ListView dateTable = (ListView) findViewById(R.id.dateTable);

        final StableArrayAdapter adapter1 = new StableArrayAdapter(this,
                android.R.layout.simple_list_item_1, DaysOfWeek);
        dateTable.setAdapter(adapter1);
    }
}
