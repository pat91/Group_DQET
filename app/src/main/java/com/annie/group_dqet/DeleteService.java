package com.annie.group_dqet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteService extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_service);
    }


    public void deleteService(View view) {
        EditText serviceName=(EditText)findViewById(R.id.serviceName);
        Database db=new Database(this);

        //check for invalid fields
        if(serviceName.getText().toString().equals("")){
            //message empty fields
            Toast error = Toast.makeText(DeleteService.this, "invalid fields", Toast.LENGTH_SHORT);
            error.show();
        }
        else{

            if(db.deleteService(serviceName.getText().toString())){
                //message service deleted
                Toast serviceDeleted = Toast.makeText(DeleteService.this, "service deleted", Toast.LENGTH_SHORT);
                serviceDeleted.show();

                Intent intent = new Intent(this, AdminActivity.class);
                startActivity(intent);
            }
            else{
                //message service doesnt exist
                Toast error = Toast.makeText(DeleteService.this, "service doesnt exist", Toast.LENGTH_SHORT);
                error.show();
            }

        }

    }

}