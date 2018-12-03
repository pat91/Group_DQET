package com.annie.group_dqet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreateService extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_service);
    }

    public void createService(View view) {
        EditText serviceName=(EditText)findViewById(R.id.serviceName);
        EditText serviceAmount=(EditText)findViewById(R.id.serviceAmount);

        //check for an empty space
        if(serviceName.getText().toString().equals("") || serviceAmount.getText().toString().equals("")){
            //show error if fields are empty
            Toast error = Toast.makeText(CreateService.this, "Invalid fields", Toast.LENGTH_SHORT);
            error.show();
        }
        else{
            //check if the serviceName already exist in the database
            Database db=new Database(this);
            Service service=db.findService(serviceName.getText().toString());
            if(service != null){
                //show error if the service name already exist
                Toast error = Toast.makeText(CreateService.this, "service already exist", Toast.LENGTH_SHORT);
                error.show();
            }
            else{
                //add new service
                service=new Service(serviceName.getText().toString(), Integer.parseInt(serviceAmount.getText().toString()));
                db.createService(service);
                //show the service is created
                Toast serviceAdded = Toast.makeText(CreateService.this, "service added", Toast.LENGTH_SHORT);
                serviceAdded.show();

                Intent intent = new Intent(this, AdminActivity.class);
                startActivity(intent);
            }

        }

    }

}