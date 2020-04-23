package com.example.qrcode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TCLelectronics extends AppCompatActivity {
    private Button tcl_tv1;
    private Button tcl_plex1;
    private Button tcl_accessories1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tclelectronics);

        tcl_tv1 = (Button) findViewById(R.id.tcl_tv);
        tcl_plex1=(Button) findViewById(R.id.tcl_plex);
        tcl_accessories1 = (Button) findViewById(R.id.tcl_accessories);

        tcl_tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_activitygirendaki1();

            }
        });

        tcl_plex1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_activitygirendaki(); //this is qr code window
            }
        });

        tcl_accessories1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_activitygirendaki2(); // this is also qr code window
            }
        });


    }

    public void open_activitygirendaki(){

        Intent intent =  new Intent(this, girendaki.class);//girendaki hemmesi ucin comman suwagt, hacanda database-i onaramda duzetmeli button ucin ayry etmeli
        startActivity(intent);
    }

    public void open_activitygirendaki1(){

        Intent intent = new Intent(this, girendaki.class); //girendaki hemmesi ucin comman suwagt, hacanda database-i onaramda duzetmeli button ucin ayry etmeli
        startActivity(intent);
    }
    public void open_activitygirendaki2(){

        Intent intent = new Intent(this, girendaki.class); //girendaki hemmesi ucin comman suwagt, hacanda database-i onaramda duzetmeli button ucin ayry etmeli
        startActivity(intent);
    }
}
