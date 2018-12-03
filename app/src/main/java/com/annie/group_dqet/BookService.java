package com.annie.group_dqet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class BookService extends AppCompatActivity {


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_booked);
        }

        public void btnLoutOutBooked (View v){
            Intent intent = new Intent(this, OwnerOption.class );
            startActivity(intent);

    }

    public void btnRateService(View view) {
            Intent intent = new Intent (this, Rating.class);
            startActivity(intent);
    }
}
