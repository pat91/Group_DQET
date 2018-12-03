package com.annie.group_dqet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class ServiceProvider extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_provider);

        TextView eText = (TextView) findViewById(R.id.tvWelcomeServiceProvider);

        Intent intent = getIntent();
        Bundle username = intent.getExtras();
        String usernameStr = (String)username.get("username");

        String welcomeMessageServiceProvider = "Bienvenu " + usernameStr + "! Vous avez une session en tant que Service Provider.";
        eText.setText(welcomeMessageServiceProvider);

    }

    public void btnLogOutServiceProvider(View view) {
        if(view.getId() == R.id.btnLogOutServiceProvider) {
            Intent intent = new Intent(ServiceProvider.this, MainActivity.class);
            startActivity(intent);
        }
    }

    public void btnCompleteProfileClick(View view){

        Intent intent = new Intent(this, CompleteProfile.class);
        startActivity(intent);

    }

}
