package com.annie.group_dqet;

/*
 * This is the page that the admin sees when they log in
 */


import java.util.*;
import android.widget.Toast;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
    }

    public void createService(View view) {
        Intent intent = new Intent(getApplicationContext(),CreateService.class);
        startActivity(intent);

    }


    public void deleteService(View view) {
        Intent intent = new Intent(getApplicationContext(),DeleteService.class);
        startActivity(intent);

    }


    public void editService(View view) {
        Intent intent = new Intent(getApplicationContext(),EditService.class);
        startActivity(intent);

    }


    public void viewAllServices(View view) {

        Database db=new Database(this);

        ArrayList<String> list=db.listTable();

        if(list.size()>0){

            Intent intent = new Intent(getApplicationContext(),ViewAllServices.class);
            startActivity(intent);

        }
        else {
            //message no services available
            Toast error = Toast.makeText(AdminActivity.this, "no services available", Toast.LENGTH_SHORT);
            error.show();
        }


    }



}