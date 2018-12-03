package com.annie.group_dqet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.content.Intent;

public class Rating extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
    }

    public void btnRate(View view) {
        Toast error = Toast.makeText(this,"Your rating has been submitted", Toast.LENGTH_SHORT);
        error.show();

        Intent intent = new Intent(this, OwnerOption.class );
        startActivity(intent);

    }
}
