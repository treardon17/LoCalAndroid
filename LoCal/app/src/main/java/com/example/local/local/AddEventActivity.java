package com.example.local.local;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

public class AddEventActivity extends AppCompatActivity {

    private Button cancelButton;
    private Button acceptButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        cancelButton = (Button)findViewById(R.id.cancelButtonAddEvent);
        acceptButton = (Button)findViewById(R.id.acceptButtonAddEvent);
    }

    public void cancelAction(View view){
        finish();
    }

    public void acceptAction(View view){
        finish();
    }

    public void showDatePicker(View view){
        DatePicker datePicker = (DatePicker) findViewById(R.id.startDate);
        datePicker.setVisibility(View.VISIBLE);
    }

}
