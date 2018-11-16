package com.example.kgitbank.scheduller;

import android.content.Context;
import android.os.LocaleList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    String temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Context ctx = MainActivity.this;
        final TextView today = findViewById(R.id.today);
        /*자바에서 오늘 날짜 가져오는 방법*/
        Date d = new Date();
        today.setText(new SimpleDateFormat("yyyy-MM-dd hh:mm")
                    .format(d));
        final CalendarView calendarView= findViewById(R.id.calendar);
        final TimePicker timePicker = findViewById(R.id.timePicker);
        final TextView year = findViewById(R.id.year);
        final TextView month = findViewById(R.id.month);
        final TextView date = findViewById(R.id.date);
        final TextView hour = findViewById(R.id.hour);
        final TextView minute = findViewById(R.id.minute);

        timePicker.setVisibility(View.INVISIBLE);


        /*달력값 지정하는 메소드 */
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {

                temp=year+"-"+(month+1)+"-"+dayOfMonth;
            }
        });
        findViewById(R.id.rdDate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePicker.setVisibility(View.INVISIBLE);
                calendarView.setVisibility(View.VISIBLE);
            }
        });
        findViewById(R.id.rdTime).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePicker.setVisibility(View.VISIBLE);
                calendarView.setVisibility(View.INVISIBLE);
            }
        });

        findViewById(R.id.confirmBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("선택한 날짜 ",temp);
                String[] arr = temp.split("-");
                year.setText(arr[0]);
               month.setText(arr[1]);
                date.setText(arr[2]);
                hour.setText(String.valueOf(timePicker.getHour()));
                minute.setText(String.valueOf(timePicker.getMinute()));
            }
        });
    }
}
