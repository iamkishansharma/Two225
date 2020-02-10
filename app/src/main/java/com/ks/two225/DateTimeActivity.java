package com.ks.two225;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class DateTimeActivity extends AppCompatActivity {

    DatePicker datepic;
    TimePicker timepic;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time);

        datepic = findViewById(R.id.datepic);
        timepic = findViewById(R.id.timepic);
        t1 = findViewById(R.id.tv1);

        datepic.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                String aa = datepic.getDayOfMonth()+"/"+datepic.getMonth()+"/"+datepic.getYear();
                t1.setText(aa);
                Toast.makeText(DateTimeActivity.this,aa,Toast.LENGTH_LONG).show();
            }
        });

        timepic.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {

                String tt = timepic.getHour()+" : "+timepic.getMinute();
                t1.setText(tt);
                Toast.makeText(DateTimeActivity.this,tt,Toast.LENGTH_LONG).show();
            }
        });
    }
}
