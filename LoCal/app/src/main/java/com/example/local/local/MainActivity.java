package com.example.local.local;

import android.app.usage.UsageEvents;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import java.util.*;
import android.widget.*;
import android.widget.TextView;
import android.content.Intent;
import android.view.*;


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

//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            View row = convertView;
//
//////            if(row == null)
//////            {
//////                LayoutInflater inflater = ((Activity)context).getLayoutInflater();
//////                row = inflater.inflate(layoutResourceId, parent, false);
//////
//////                holder = new WeatherHolder();
//////                holder.imgIcon = (ImageView)row.findViewById(R.id.imgIcon);
//////                holder.txtTitle = (TextView)row.findViewById(R.id.txtTitle);
//////
//////                row.setTag(holder);
//////            }
//////            else
//////            {
//////                holder = (WeatherHolder)row.getTag();
//////            }
//////
//////            Weather weather = data[position];
//////            holder.txtTitle.setText(weather.title);
//////            holder.imgIcon.setImageResource(weather.icon);
//////
//////            return row;
////        }
//        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView calendarView = (ListView) findViewById(R.id.calendarView);


        String[] events = new String[]{"Mobile Applications Development", "Artificial Intelligence",
        "Psychology", "Lunch", "Dinner", "TV", "Other stuff", "Homework", "Work on Calendar", "Brush Teeth", "Get Pillow", "Go to sleep"};

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

    }

    public void onSaveInstanceState(Bundle savedInstanceState){

    }

    public void addEvent(View view){
        Intent intent = new Intent(this, AddEventActivity.class);
        startActivity(intent);
    }

    public void addLocation(View view){
        Intent intent = new Intent(this, AddLocationActivity.class);
        startActivity(intent);
    }

}
