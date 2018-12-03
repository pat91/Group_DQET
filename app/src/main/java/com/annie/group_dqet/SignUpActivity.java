package com.annie.group_dqet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    private EditText username, email, password, userType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        username = (EditText)findViewById(R.id.etUserUsername);
        email = (EditText) findViewById(R.id.etUserEmail);
        password = (EditText) findViewById(R.id.etUserPassword);
        userType = (EditText)findViewById(R.id.etUserType);

    }


    public void btnJoinNowClick(View view) {

        if(view.getId() == R.id.btnJoinNow){

            String usernameStr = username.getText().toString();
            String emailStr = email.getText().toString();
            String passwordStr = password.getText().toString();
            String userTypeStr = userType.getText().toString();
            Database db=new Database(this);

            userTypeStr = userTypeStr.toLowerCase().replaceAll("\\s+","");

            if(!usernameStr.equals("") && !emailStr.equals("") && !passwordStr.equals("") && !userTypeStr.equals("")) {

                // validate email address
                if(!isValidEmailAddress(emailStr)){
                    Toast error = Toast.makeText(SignUpActivity.this, "Invalid email address", Toast.LENGTH_SHORT);
                    error.show();
                    return;
                }
                else {

                    User user=db.findUser(usernameStr);

                    if(user==null){

                        // if user type is service provider, then they are redirected to a service provider page
                        if(userTypeStr.equals("serviceprovider")) {

                            User usr=new User("serviceProvider", usernameStr, "", passwordStr, "", 0, "", emailStr, "");

                            db.createUser(usr);

                            Toast msg = Toast.makeText(SignUpActivity.this, "new user added", Toast.LENGTH_SHORT);
                            msg.show();

                            Intent intent = new Intent(SignUpActivity.this,MainActivity.class);
                            startActivity(intent);

                           /*Intent intent = new Intent(SignUpActivity.this,ServiceProvider.class);
                           intent.putExtra("username",usernameStr);
                           startActivity(intent);*/
                        }


                        // if user type is owner, then they are redirected to an owner page
                        else if(userTypeStr.equals("owner")){

                            User usr=new User("owner", usernameStr, "", passwordStr, "", 0, "", emailStr, "");

                            db.createUser(usr);

                            Toast msg = Toast.makeText(SignUpActivity.this, "new user added", Toast.LENGTH_SHORT);
                            msg.show();

                            Intent intent = new Intent(SignUpActivity.this,MainActivity.class);
                            startActivity(intent);

                           /* Intent intent = new Intent(SignUpActivity.this,Owner.class);
                           intent.putExtra("username",usernameStr);
                           startActivity(intent);*/
                        }

                        else {
                            Toast error = Toast.makeText(SignUpActivity.this, "Invalid user type", Toast.LENGTH_SHORT);
                            error.show();
                            return;
                        }

                    }

                    else {

                        Toast mg = Toast.makeText(SignUpActivity.this, "username already exist", Toast.LENGTH_SHORT);
                        mg.show();

                    }

                }

            }

            else {
                Toast error = Toast.makeText(SignUpActivity.this, "One or more fields are empty", Toast.LENGTH_SHORT);
                error.show();
                return;
            }


        }

    }

    // validate email address code from Stack Overflow
    // https://stackoverflow.com/questions/624581/what-is-the-best-java-email-address-validation-method/24320945
    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

}


