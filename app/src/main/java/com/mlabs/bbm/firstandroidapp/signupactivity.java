package com.mlabs.bbm.firstandroidapp;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.mlabs.bbm.firstandroidapp.R.id.username;

/**
 * Created by RalphPogi on 17/09/16.
 */
public class signupactivity extends AppCompatActivity implements View.OnClickListener {
    TextView firstname;
    TextView lastname;
    TextView username;
    TextView email;
    TextView password;
    TextView confirmPassword;
    Button create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        //  final databaseAdapter sqlite = new databaseAdapter(getApplicationContext());
        /** final SimpleDateFormat currentDate = new SimpleDateFormat("dd/MM/yyyy");
         final Date todayDate = new Date();
         final String thisDate = currentDate.format(todayDate);
         final EditText email = (EditText) findViewById(R.id.email);
         final EditText password = (EditText) findViewById(R.id.pass);
         final EditText confirmPassword = (EditText) findViewById(R.id.cpass);
         final EditText username = (EditText) findViewById(R.id.username);
         final EditText firstname = (EditText) findViewById(R.id.Firstname);
         final EditText lastname = (EditText) findViewById(R.id.Lastname);
         Button btnRegister = (Button) findViewById(R.id.btnregister); **/
       // create.setOnClickListener((this);
        firstname = (TextView) findViewById(R.id.Firstname);
        lastname = (TextView) findViewById(R.id.Lastname);
        username = (TextView) findViewById(R.id.username);
        email = (TextView) findViewById(R.id.email);
        password = (TextView) findViewById(R.id.pass);
        confirmPassword = (TextView) findViewById(R.id.cpass);
        create = (Button) findViewById(R.id.btnregister);

        create.setOnClickListener(this);

    }
    public void onClick(View view) {
        /* String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";*/
        if (view == findViewById(R.id.btnregister)){
            if (Pattern.compile("^\\w+.*\\w*@"+"([a-zA-Z_])+(\\.[0-9a-zA-Z]{2,})*(\\.[0-9a-zA-Z]{2,})$").matcher(email.getText()).matches())
            {
                if (password.getText().toString().equals(confirmPassword.getText().toString())){
                    if (password.getText().toString().length() >= 8){
                        dbopen acct = new dbopen();
                        Calendar c = Calendar.getInstance();
                        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                        String formattedDate = df.format(c.getTime());
                        if (Pattern.compile("^\\w+.*\\w*@"+"([a-zA-Z_])+(\\.[0-9a-zA-Z]{2,})*(\\.[0-9a-zA-Z]{2,})$").matcher(username.getText()).matches()) {
                            Toast.makeText(getBaseContext(), "Username should not be in Email format.", Toast.LENGTH_SHORT).show();
                        }else {

                            adaptdb repo = new adaptdb(this);
                            acct.getfirstname = firstname.getText().toString();
                            acct.getlastname = lastname.getText().toString();
                            acct.getusername = username.getText().toString();
                            acct.getemail = email.getText().toString();
                            acct.getpassword = password.getText().toString();
                            acct.getdatecreated = formattedDate;
                            if(repo.isExisting(acct) == false){
                                int a = 0;
                                a = repo.createAccount(acct);
                                Toast.makeText(this, "New account added!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(signupactivity.this, Login.class);
                                                                //intent2.getString;
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(getBaseContext(), "Username or Email are already exists!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                    else  {
                        Toast.makeText(this, "Password should be atleast 8 characters", Toast.LENGTH_SHORT).show();
                    }
                }
                else   {
                    Toast.makeText(this, "password is not match", Toast.LENGTH_SHORT).show();
                }
            }
            else   {
                Toast.makeText(this, "Incorrect email validation.", Toast.LENGTH_SHORT).show();
            }
        }
    }
    protected  void onPause() {
        super.onPause();
        finish();
    }
}

