package com.example.qrcode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button tcl_communication1;
    private Button tcl_electronics1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tcl_communication1 = (Button) findViewById(R.id.tcl_communication);
        tcl_electronics1 = (Button) findViewById(R.id.tcl_electronics);



        tcl_communication1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_tclcommunication();

            }
        });



        tcl_electronics1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_tclelectronics();
            }
        });


    }

    public void open_tclcommunication(){

        Intent intent =  new Intent(this, TCLcommunication.class);
        startActivity(intent);
    }

    public void open_tclelectronics(){

        Intent intent = new Intent(this, TCLelectronics.class);
        startActivity(intent);
    }

}
