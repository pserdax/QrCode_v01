package com.example.qrcode;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {
    DatabaseHelperLg db;
    EditText etEmail, etPass;
    Button btnLogin;
    TextView tvReg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DatabaseHelperLg(this);


        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etPass);


        btnLogin = findViewById(R.id.btnLogin);
        tvReg = findViewById(R.id.tvReg);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email, password;
                Boolean Chkemailpass;
                email = etEmail.getText().toString();
                password = etPass.getText().toString();
                Chkemailpass = db.emailpassword(email, password);

                if(Chkemailpass==true) {


                    Toast.makeText(login.this, "Successfully Login", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(v.getContext(), MainActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(login.this, "Wrong email or password", Toast.LENGTH_SHORT).show();
                }

                if(email.equals("")){

                    Toast.makeText(login.this, "Email Required", Toast.LENGTH_SHORT).show();
                }
                else if(password.equals("")){
                    Toast.makeText(login.this, "Password Required", Toast.LENGTH_SHORT).show();



                }
                else{
                    //Authentoication
                }
            }
        });

        tvReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(login.this, Registration.class);
                startActivity(i);
                finish();

            }
        });


    }
}
