package com.example.qrcode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class chooseBlackberry extends AppCompatActivity {
    private Button phone_blackberry1;
    private Button tablet_blackberry1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_blackberry);

        phone_blackberry1 = (Button) findViewById(R.id.blackberry_phone);
        tablet_blackberry1 = (Button) findViewById(R.id.blackberry_tablet);

        phone_blackberry1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_activitygirendaki1();

            }
        });
        tablet_blackberry1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_activitygirendaki(); //this is qr code window
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
    }

