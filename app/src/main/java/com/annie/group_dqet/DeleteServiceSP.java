package com.annie.group_dqet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class DeleteServiceSP extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_service_sp);
    }


    public void deleteServiceSP(View view) {
        EditText serviceName=(EditText)findViewById(R.id.serviceNameSP);
        Database db=new Database(this);

        //check for invalid fields
        if(serviceName.getText().toString().equals("")){
            //message empty fields
            Toast error = Toast.makeText(this, "invalid fields", Toast.LENGTH_SHORT);
            error.show();
        }
        else{

            if(db.deleteServiceSP(serviceName.getText().toString())){
                //message service deleted
                Toast serviceDeleted = Toast.makeText(this, "service deleted", Toast.LENGTH_SHORT);
                serviceDeleted.show();

                Intent intent = new Intent(this, ShowProfile.class);
                startActivity(intent);
            }
            else{
                //message service doesnt exist
                Toast error = Toast.makeText(this, "service doesnt exist", Toast.LENGTH_SHORT);
                error.show();
            }

        }

    }
}
