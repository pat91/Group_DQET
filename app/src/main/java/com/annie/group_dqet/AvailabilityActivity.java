package com.annie.group_dqet;


import java.util.*;
import android.widget.Toast;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class AvailabilityActivity extends AppCompatActivity { // inspired from: https://www.mkyong.com/android/android-spinner-drop-down-list-example/

    private Spinner spinnerWeek, spinnerFrom, spinnerTo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_availabilities);

        addItemsOnSpinnerWeek(); // When creating, it will add the items to the designed spinner
        addItemsOnSpinnerFrom();
        addItemsOnSpinnerTo();
    }

    public void addItemsOnSpinnerFrom() {
        spinnerFrom = (Spinner) findViewById(R.id.spinnerFrom);
        List<String> list = new ArrayList<String>();
        list.add("00:00");
        list.add("01:00");
        list.add("02:00");
        list.add("03:00");
        list.add("04:00");
        list.add("05:00");
        list.add("06:00");
        list.add("07:00");
        list.add("08:00");
        list.add("09:00");
        list.add("10:00");
        list.add("11:00");
        list.add("12:00");
        list.add("13:00");
        list.add("14:00");
        list.add("15:00");
        list.add("16:00");
        list.add("17:00");
        list.add("18:00");
        list.add("19:00");
        list.add("20:00");
        list.add("21:00");
        list.add("22:00");
        list.add("23:00");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFrom.setAdapter(arrayAdapter);

    }

    public void addItemsOnSpinnerTo() {
        spinnerTo = (Spinner) findViewById(R.id.spinnerTo);
        List<String> list = new ArrayList<String>();
        list.add("00:00");
        list.add("01:00");
        list.add("02:00");
        list.add("03:00");
        list.add("04:00");
        list.add("05:00");
        list.add("06:00");
        list.add("07:00");
        list.add("08:00");
        list.add("09:00");
        list.add("10:00");
        list.add("11:00");
        list.add("12:00");
        list.add("13:00");
        list.add("14:00");
        list.add("15:00");
        list.add("16:00");
        list.add("17:00");
        list.add("18:00");
        list.add("19:00");
        list.add("20:00");
        list.add("21:00");
        list.add("22:00");
        list.add("23:00");
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTo.setAdapter(arrayAdapter2);

    }

    public void addItemsOnSpinnerWeek() {


        spinnerWeek = (Spinner) findViewById(R.id.spinnerWeek);
        List<String> list = new ArrayList<String>();
        list.add("Monday");
        list.add("Tuesday");
        list.add("Wednesday");
        list.add("Thursday");
        list.add("Friday");
        list.add("Saturday");
        list.add("Sunday");

        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerWeek.setAdapter(arrayAdapter2);


    }

    public void btnCreateEvent(View v) {
        String weekStr = String.valueOf(spinnerWeek.getSelectedItem());
        String fromStr = String.valueOf(spinnerFrom.getSelectedItem());
        String toStr = String.valueOf(spinnerTo.getSelectedItem());

        Database db = new Database(this);
        Availability availability = db.findAvailability(weekStr);

        //add new availability
        availability = new Availability(weekStr, fromStr, toStr);
        db.createAvailability(availability);
        //show the service is created
        Toast serviceAdded = Toast.makeText(this, "availability added", Toast.LENGTH_SHORT);
        serviceAdded.show();

        Intent intent = new Intent(this, AvailabilityList.class);
        startActivity(intent);


    }
}



