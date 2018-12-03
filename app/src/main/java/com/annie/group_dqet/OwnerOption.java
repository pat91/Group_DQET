package com.annie.group_dqet;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.PopupMenu;
import android.view.MenuItem;

public class OwnerOption extends AppCompatActivity {
    Button filter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_options);

        filter = (Button) findViewById(R.id.filter);
        filter.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(OwnerOption.this, filter);
                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.layout.filter_menu, popup.getMenu());
                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {

                        Intent intent = new Intent(OwnerOption.this, ListSP.class);
                        intent.putExtra("filter",item.getTitle());
                        startActivity(intent);

                        return true;
                    }

                });
                popup.show();//showing popup menu
            }
        });//closing the setOnClickListener method


    }

    public void btnBookAService (View view){
        Intent intent = new Intent(this, ViewServiceProviderServices.class);
        startActivity(intent);
    }




}
