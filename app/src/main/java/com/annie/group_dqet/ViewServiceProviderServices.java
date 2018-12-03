package com.annie.group_dqet;

import java.util.*;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;


public class ViewServiceProviderServices extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp_services);

        ListView listView = (ListView) findViewById(R.id.serviceProviderList);

        Database db=new Database(this);

        ArrayList<String> list= new ArrayList<String>();

        list=db.listTableSP();



        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,  android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


               Intent intent = new Intent(ViewServiceProviderServices.this, AvailabilityList.class);
               startActivity(intent);
            }
        });

    }

}
