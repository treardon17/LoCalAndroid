package com.example.local.local;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.ArrayList;

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
        EditText eventName = (EditText) findViewById(R.id.eventName);
        Intent output = new Intent();
        output.putExtra("eventName", eventName.getText().toString());
        setResult(RESULT_OK, output);
        finish();
    }

    public void showDatePicker(View view){
        DatePicker datePicker = (DatePicker) findViewById(R.id.startDate);
        datePicker.setVisibility(View.VISIBLE);
    }

}
