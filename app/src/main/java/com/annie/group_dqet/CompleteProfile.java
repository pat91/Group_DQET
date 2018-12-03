package com.annie.group_dqet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class CompleteProfile extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_profile);

    }


    public void btnSaveProfile(View view){

        String companyName = ((EditText) findViewById(R.id.etNameCompany)).getText().toString();
        String address = ((EditText) findViewById(R.id.etAddressCompany)).getText().toString();
        String phoneNumber=((EditText) findViewById(R.id.etPhoneCompany)).getText().toString();
        String description=((EditText) findViewById(R.id.etGeneralDescription)).getText().toString();
        String licence=((EditText) findViewById(R.id.etLiscensed)).getText().toString();

        Intent intent = new Intent(CompleteProfile.this, ShowProfile.class);

        if(!companyName.replaceAll("\\s+","").equals("") && !address.replaceAll("\\s+","").equals("") && !phoneNumber.replaceAll("\\s+","").equals("") && !description.replaceAll("\\s+","").equals("") && !licence.replaceAll("\\s+","").equals("")){

            if(licence.toLowerCase().replaceAll("\\s+","").equals("yes") || licence.toLowerCase().replaceAll("\\s+","").equals("no")){

                if(validateAddress(address)){
                    startActivity(intent);
                }
                else {
                    Toast error = Toast.makeText(CompleteProfile.this,"Invalid address", Toast.LENGTH_SHORT);
                    error.show();
                }
            }

            else{
                Toast error = Toast.makeText(CompleteProfile.this,"Invalid licence", Toast.LENGTH_SHORT);
                error.show();
            }
        }

        else{
            Toast error = Toast.makeText(CompleteProfile.this,"invalid field", Toast.LENGTH_SHORT);
            error.show();

        }

    }

    // retrieved from http://www.java2s.com/Tutorial/Java/0120__Development/ValidateAddress.htm
    // validate address
    public static boolean validateAddress( String address )
    {
        return address.matches(
                "\\d+\\s+([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)" );
    } // end method validateAddress
}
