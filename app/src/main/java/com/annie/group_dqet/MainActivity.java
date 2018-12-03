package com.annie.group_dqet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;








public class MainActivity extends AppCompatActivity {

    // create all necessary instance variables for login page
    private EditText username;
    private EditText password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.etUsername);
        password = (EditText) findViewById(R.id.etPassword);


    }

    // what happens when user presses login button
    public void btnLoginClick(View view) {

        // if login button is clicked
        if (view.getId() == R.id.btnLogin) {
            String emailStr = username.getText().toString();
            String passwordStr = password.getText().toString();

            Database db=new Database(this);
            User usr=db.findUser(emailStr);

            // if admin logs in, then they are redirected to the admin page

            if(emailStr.equals("admin") && passwordStr.equals("admin")) {
                Intent intent = new Intent(MainActivity.this, AdminActivity.class);
                startActivity(intent);
            }
            else if(usr!=null && usr.getUserName().equals(emailStr) && usr.getPassWord().equals(passwordStr) && usr.getUserType().equals("owner")){
                Intent intent = new Intent(MainActivity.this, Owner.class);
                intent.putExtra("username",usr.getUserName());
                startActivity(intent);

            }
            else if(usr!=null && usr.getUserName().equals(emailStr) && usr.getPassWord().equals(passwordStr) && usr.getUserType().equals("serviceProvider")){
                Intent intent = new Intent(MainActivity.this, ServiceProvider.class);
                intent.putExtra("username",usr.getUserName());
                startActivity(intent);
            }
            else {

                Toast error = Toast.makeText(MainActivity.this,"Username or password is invalid", Toast.LENGTH_SHORT);
                error.show();

            }

        }

    }



    public void btnSignUpClick(View view) {
        Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
        startActivity(intent);
    }
}







