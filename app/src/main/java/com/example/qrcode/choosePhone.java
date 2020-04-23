package com.example.qrcode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class choosePhone extends AppCompatActivity {
    private Button alcatel_phone1;
    private Button alcatel_tablet1;
    private Button alcatel_wearable1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_phone);

        alcatel_phone1 = (Button) findViewById(R.id.alcatel_phone);
        alcatel_tablet1 = (Button) findViewById(R.id.alcatel_tablet);
        alcatel_wearable1 = (Button) findViewById(R.id.alcatel_wearable);

        alcatel_phone1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_activitygirendaki1();

            }
        });

        alcatel_tablet1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_activitygirendaki(); //this is qr code window
            }
        });

        alcatel_wearable1.setOnClickListener(new View.OnClickListener() {
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

