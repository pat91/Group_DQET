package com.annie.group_dqet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreateServiceSP extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_service_sp);
    }

    public void createServiceProvider(View view) {
        EditText serviceName = (EditText) findViewById(R.id.serviceNameSP);
        EditText serviceAmount = (EditText) findViewById(R.id.serviceAmountSP);

        //check for an empty space
        if (serviceName.getText().toString().equals("") || serviceAmount.getText().toString().equals("")) {
            //show error if fields are empty
            Toast error = Toast.makeText(this, "Invalid fields", Toast.LENGTH_SHORT);
            error.show();
        } else {
            //check if the serviceName already exist in the database
            Database db = new Database(this);
            ServiceSP service = db.findServiceSP(serviceName.getText().toString());
            if (service != null) {
                //show error if the service name already exist
                Toast error = Toast.makeText(this, "service already exist", Toast.LENGTH_SHORT);
                error.show();
            } else {
                //add new service
                service = new ServiceSP(serviceName.getText().toString(), Integer.parseInt(serviceAmount.getText().toString()));
                db.createServiceSP(service);
                //show the service is created
                Toast serviceAdded = Toast.makeText(this, "service added", Toast.LENGTH_SHORT);
                serviceAdded.show();

                Intent intent = new Intent(this, ShowProfile.class);
                startActivity(intent);
            }

        }
    }


    }

