package com.example.qrcode;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Registration extends AppCompatActivity {
    DatabaseHelperLg db;
    EditText etEmail, etPass, etConPass;
    Button btnReg;
    TextView tvLog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        db = new DatabaseHelperLg(this);


        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etPass);
        etConPass = findViewById(R.id.etConPass);
        tvLog = findViewById(R.id.tvLog);


        btnReg = findViewById(R.id.btnReg);

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email, pass, conPass;
                email = etEmail.getText().toString();
                pass = etPass.getText().toString();
                conPass = etConPass.getText().toString();



                if(email.equals("")){

                    Toast.makeText(Registration.this, "Email Required", Toast.LENGTH_SHORT).show();
                }
                else if(pass.equals("")){
                    Toast.makeText(Registration.this, "Password Required", Toast.LENGTH_SHORT).show();



                }
                else if(conPass.equals("")){

                    Toast.makeText(Registration.this, "Confirmation password Required", Toast.LENGTH_SHORT).show();
                }
                else if(!conPass.equals(pass)){

                    Toast.makeText(Registration.this, "Password doesn't match", Toast.LENGTH_SHORT).show();
                }


                else{
                    if(pass.equals(conPass)){

                        Boolean chkemail  = db.chkemail(email);
                        if (chkemail==true){

                            Boolean insert =db.insert(email, pass);

                            if(insert ==true){
                                Toast.makeText(Registration.this, "Registered Successfully :)", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(Registration.this, "E-mail Already Used :(", Toast.LENGTH_SHORT).show();
                        }


                    }
                }

            }
        });
        tvLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hi = new Intent(Registration.this, login.class);
                startActivity(hi);
                finish();

            }
        });
    }
}
