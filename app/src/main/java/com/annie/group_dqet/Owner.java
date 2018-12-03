package com.annie.group_dqet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Owner extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner);

        TextView eText = (TextView) findViewById(R.id.tvWelcomeOwner);

        Intent intent = getIntent();
        Bundle username = intent.getExtras();
        String usernameStr = (String)username.get("username");

        String welcomeMessageOwner = "Bienvenue " + usernameStr + "! Vous avez une session en tant que propriétaire.";
        eText.setText(welcomeMessageOwner);
    }

    public void btnLogOutOwner(View view) {
        if(view.getId() == R.id.btnLogOutOwner) {
            Intent intent = new Intent(Owner.this,MainActivity.class);
            startActivity(intent);
        }
    }

    public void btnNext(View view) {
        if(view.getId() == R.id.btnNext) {
            Intent intent = new Intent(Owner.this,OwnerOption.class);
            startActivity(intent);
        }
    }


}

