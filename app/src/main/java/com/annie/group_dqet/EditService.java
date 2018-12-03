package com.annie.group_dqet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EditService extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_service);
    }

    public void editService(View view) {
        EditText serviceName=(EditText)findViewById(R.id.serviceName);
        EditText newServiceName=(EditText)findViewById(R.id.newServiceName);
        EditText newServiceAmount=(EditText)findViewById(R.id.newServiceAmount);
        Database db=new Database(this);


        //check for invalid fields
        if(serviceName.getText().toString().equals("")||newServiceName.getText().toString().equals("")||newServiceAmount.getText().toString().equals("")){
            //message empty fields
            Toast error = Toast.makeText(EditService.this, "invalid fields", Toast.LENGTH_SHORT);
            error.show();
        }
        else{
            //delete the old service
            if(db.deleteService(serviceName.getText().toString())){
                //add new service
                Service service=new Service(newServiceName.getText().toString(), Integer.parseInt(newServiceAmount.getText().toString()));
                db.createService(service);
                //message the service is modified
                Toast serviceModified = Toast.makeText(EditService.this, "service modified", Toast.LENGTH_SHORT);
                serviceModified.show();
                Intent intent = new Intent(this, AdminActivity.class);
                startActivity(intent);

            }
            else{
                //message the service is not found
                Toast error = Toast.makeText(EditService.this, "service doesnt exist", Toast.LENGTH_SHORT);
                error.show();
            }

        }

    }

}
