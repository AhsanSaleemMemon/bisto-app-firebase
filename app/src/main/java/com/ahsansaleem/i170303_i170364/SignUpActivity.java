package com.ahsansaleem.i170303_i170364;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    TextView login_page;
    EditText email, password, confirm_password;

    String[] emails = {"ahsanmemon288@gmail.com", "aqeelejaz238@gmail.com", "anonymous123@gmail.com"};
    String[] passwords = {"user123", "user456", "user678"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        email = findViewById(R.id.email_input);
        password = findViewById(R.id.pass_input);
        confirm_password = findViewById(R.id.confirm_pass_input);

        Button signUpBtn = findViewById(R.id.sign_up_btn);

        login_page=findViewById(R.id.login_page);
        login_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });




        signUpBtn.setOnClickListener(new View.OnClickListener() {

            String emailString = email.getText().toString();
            String passwordString=password.getText().toString();
            String confirm_passwordString=confirm_password.getText().toString();

            @Override
            public void onClick(View view) {


                if(areAllFielsFilled()) {
                    for (int i = 0; i < 3; i++) {
                        if (emails[i].equalsIgnoreCase("ahsanmemon288@gmail.com") && passwords[i].equals("user123") && passwords[i].equals("user123")) {
                            Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                            startActivity(intent);
                            Toast.makeText(SignUpActivity.this,"correct credentials",Toast.LENGTH_SHORT).show();
                            break;
                        }
                        else{
                            Toast.makeText(SignUpActivity.this,"incorrect credentials",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
    }


    boolean areAllFielsFilled(){
        if (!email.getText().toString().isEmpty() && !password.getText().toString().isEmpty() && !confirm_password.getText().toString().isEmpty()){
            return true;
        }
        else{
            return false;
        }

    }



}