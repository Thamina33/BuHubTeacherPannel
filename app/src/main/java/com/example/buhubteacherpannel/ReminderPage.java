package com.example.buhubteacherpannel;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class ReminderPage extends AppCompatActivity {

    TextView datePicker, timePicker;
    DatePickerDialog datePickerDialog;
    String amPmChecker, date = "null", time = "null", Loc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder_page);

        timePicker = findViewById(R.id.timeEdit);
        datePicker = findViewById(R.id.dateEdit);

        datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // calling the date Picker

                Calendar c = Calendar.getInstance();

                int day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);

                datePickerDialog = new DatePickerDialog(ReminderPage.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        datePicker.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                        date = dayOfMonth + "/" + (month + 1) + "/" + year;


                    }
                }, year, month, day);

                datePickerDialog.show();
            }
        });


        timePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //calling the time picker

                TimePickerDialog timePickerDialog = new TimePickerDialog(ReminderPage.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        if (hourOfDay >= 12) {
                            amPmChecker = "AM";

                        } else {
                            amPmChecker = "PM";
                        }


                        timePicker.setText(hourOfDay + ":" + minute + " " + amPmChecker);

                        time = hourOfDay + ":" + minute + " " + amPmChecker;

                    }
                }, 0, 0, false);


                timePickerDialog.show();
            }
        });

    }
}