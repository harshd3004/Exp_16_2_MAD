package com.example.exp_16_2_mad;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    TimePickerDialog timeDialog;
    DatePickerDialog dateDialog;
    EditText dateTxt, timeTxt;
    Button setDate, setTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setDate = (Button) findViewById(R.id.btnDate);
        setTime = (Button) findViewById(R.id.btnTime);
        dateTxt = (EditText) findViewById(R.id.txtDate);
        timeTxt = (EditText) findViewById(R.id.txtTime);
        final Calendar cldr = Calendar.getInstance();

        setDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int year = cldr.get(Calendar.YEAR);
                int month = cldr.get(Calendar.MONTH);
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                dateDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                dateTxt.setText(Integer.toString(dayOfMonth)+"/"+Integer.toString(month)+"/"+Integer.toString(year));
                            }
                        },year,month,day);
                dateDialog.show();
            }
        });

        setTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int hours = cldr.get(Calendar.HOUR_OF_DAY);
                int minutes = cldr.get(Calendar.MINUTE);
                timeDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        timeTxt.setText(Integer.toString(hourOfDay)+" : "+Integer.toString(minute));
                    }
                },hours,minutes,true);
                timeDialog.show();
            }
        });
    }
}