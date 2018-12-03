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
import java.util.Collections;


public class ListSP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_sp);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String filter = (String)bundle.get("filter");

        ListView listView = (ListView) findViewById(R.id.ListSP);

        Database db = new Database(this);


        ArrayList<String> list= new ArrayList<String>();


        

        if(filter.equals("Name")){
          list = db.listSP();
          Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
        }

        else if(filter.equals("Time")) list=db.listTableAvailability();

        else if(filter.equals("Rate")){

            list.add("5/5");
            list.add("4/5");
            list.add("3/5");
            list.add("2/5");
            list.add("1/5");
        }




        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,  android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);








    }

    public void btnReturnToOptions (View view){
        Intent i = new Intent(ListSP.this, OwnerOption.class);
        startActivity(i);
    }





}
