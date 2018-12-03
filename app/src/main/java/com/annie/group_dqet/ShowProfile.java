package com.annie.group_dqet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;

import java.util.ArrayList;


public class ShowProfile extends AppCompatActivity {


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_profile);




        }

        public void viewAdminServices (View v){
            Intent i = new Intent (this, ViewAllServices.class);
            startActivity(i);

        }

        public void viewServiceProviderServices (View v){

            Database db=new Database(this);

            ArrayList<String> list=db.listTable();



            Intent intent = new Intent(this,ViewServiceProviderServices.class);
            startActivity(intent);


        }

        public void addServicesSP (View view){
            Intent intent2 = new Intent(getApplicationContext(), CreateServiceSP.class);
            startActivity(intent2);

        }
        public void deleteServicesSP (View view){
            Intent intent3 = new Intent(this, DeleteServiceSP.class);
            startActivity(intent3);

        }
        public void btnAvailabilityClick(View view){
            Intent intent4 = new Intent(this, AvailabilityActivity.class);
            startActivity(intent4);
        }
    }



