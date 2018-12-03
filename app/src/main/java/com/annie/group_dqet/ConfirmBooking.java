package com.annie.group_dqet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;

public class ConfirmBooking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_booking);
    }

    public void btnConfirmBooking (View v){
        Intent intent = new Intent(ConfirmBooking.this, BookService.class );
        startActivity(intent);

    }
    public void btnReturn(View v){
        Intent intent = new Intent(ConfirmBooking.this, ViewServiceProviderServices.class );
        startActivity(intent);
    }



}
