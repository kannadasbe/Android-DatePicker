package com.example.kannadasang.androiddatepicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    DatePicker datePicker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datePicker = (DatePicker) findViewById(R.id.datePicker);

        // To disable past date
        //datePicker.setMinDate(System.currentTimeMillis() - 1000);

        // To disable future date
        //datePicker.setMaxDate(System.currentTimeMillis() - 1000);
        Calendar today = Calendar.getInstance();

        datePicker.init(
                today.get(Calendar.YEAR),
                today.get(Calendar.MONTH),
                today.get(Calendar.DAY_OF_MONTH),
                new DatePicker.OnDateChangedListener() {

                    @Override
                    public void onDateChanged(DatePicker view,
                                              int year, int monthOfYear, int dayOfMonth) {

                        Toast.makeText(getApplicationContext(),
                                "Year: " + year + "\n" +
                                        "Month of Year: " + (monthOfYear + 1) //month is 0 based
                                        + "\n" + "Day of Month: " + dayOfMonth, Toast.LENGTH_SHORT).show();

                    }
                });

    }

    // Method to get selected date
    public String getSelectedDate() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Selected Date: ");
        stringBuilder.append((datePicker.getMonth() + 1) + "/");//month is 0 based
        stringBuilder.append(datePicker.getDayOfMonth() + "/");
        stringBuilder.append(datePicker.getYear());
        return stringBuilder.toString();
    }

}