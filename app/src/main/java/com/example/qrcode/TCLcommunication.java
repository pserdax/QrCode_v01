package com.example.qrcode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TCLcommunication extends AppCompatActivity {

    private Button alcatel1;
    private Button blackberry1;
    private Button palm1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tclcommunication);

        alcatel1 = (Button) findViewById(R.id.alcatel);
        blackberry1 = (Button) findViewById(R.id.blackberry);
        palm1 = (Button) findViewById(R.id.palm);


        alcatel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_alcatel();
            }
        });

        blackberry1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_blackberry();
            }
        });
        palm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_palm();
            }
        });
    }

        public void open_alcatel(){

            Intent intent = new Intent(this, choosePhone.class);
            startActivity(intent);




    }
        public  void open_blackberry(){

            Intent intent =  new Intent(this, girendaki.class);
            startActivity(intent);



        }

        public void open_palm(){

            Intent intent =  new Intent(this, girendaki.class);
            startActivity(intent);

        }
}
