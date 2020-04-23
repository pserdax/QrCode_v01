package com.example.qrcode;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.zxing.Result;

import java.util.HashMap;
import java.util.Map;

import javax.xml.transform.ErrorListener;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

import static android.Manifest.permission.CAMERA;


public class girendaki extends AppCompatActivity implements ZXingScannerView.ResultHandler {


    /*RequestQueue requestQueue;*/
    // String insertUrl = "http://localhost/insertdata.php";
    DatabaseHelper db;

    private static final int REQUEST_CAMERA =1;
    private ZXingScannerView scannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* requestQueue = Volley.newRequestQueue(getApplicationContext());*/
        scannerView = new ZXingScannerView(this);

        setContentView(scannerView);

        db = new DatabaseHelper(this);


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){

            if(checkPermission()) {

                Toast.makeText(girendaki.this, "Permission is granted!", Toast.LENGTH_LONG).show();
            }
            else{

                requestPermission();
            }
        }
    }
    private boolean checkPermission(){
        return (ContextCompat.checkSelfPermission(girendaki.this, CAMERA)== PackageManager.PERMISSION_GRANTED);

    }
    private void requestPermission(){
        ActivityCompat.requestPermissions(this, new String[]{CAMERA}, REQUEST_CAMERA);
    }

    public void onRequestPermissionsResult(int requestCode, String permission[], int grantResults[]){
        switch (requestCode){
            case REQUEST_CAMERA:
                if(grantResults.length>0){
                    boolean cameraAccepted =grantResults[0] ==PackageManager.PERMISSION_GRANTED;
                    if(cameraAccepted){
                        Toast.makeText(girendaki.this, "Permission Granted ", Toast.LENGTH_LONG).show();

                    }
                    else{

                        Toast.makeText(girendaki.this, "Permission Denied ", Toast.LENGTH_LONG).show();
                        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                            if(shouldShowRequestPermissionRationale(CAMERA)){
                                displayAlertMessage("You need to allow access for both permissions",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                requestPermissions(new String[]{CAMERA}, REQUEST_CAMERA);
                                            }
                                        });
                                return;

                            }
                        }
                    }
                }
                break;
        }

    }
    @Override
    public void onResume(){
        super.onResume();
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            if(checkPermission()){
                if(scannerView ==null){
                    scannerView = new ZXingScannerView(this);
                    setContentView(scannerView);
                }
                scannerView.setResultHandler(this);
                scannerView.startCamera();

            }
            else{
                requestPermission();
            }
        }
    }
    @Override
    public void onDestroy(){

        super.onDestroy();
        scannerView.stopCamera();
    }
    public void displayAlertMessage(String message, DialogInterface.OnClickListener listener){
        new AlertDialog.Builder(girendaki.this)
                .setMessage(message)
                .setPositiveButton("OK", listener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }


    @Override
    public void handleResult(Result result) {
        final String scanResult = result.getText();
        AlertDialog.Builder builder =  new AlertDialog.Builder(this);
        builder.setTitle("Scan Result is in the following");
        builder.setPositiveButton("SAVE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {





                    Boolean checking_mail  = db.chkemail(scanResult);
                    if (checking_mail==true){

                        Boolean insert =db.insert(scanResult);

                        if(insert ==true){
                            Toast.makeText(girendaki.this, "IMEI scanned successfully", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(girendaki.this, "IMEI already inserted before", Toast.LENGTH_SHORT).show();
                    }












               // insertData(scanResult);

                scannerView.resumeCameraPreview(girendaki.this);
            }
        });
       /* builder.setNeutralButton("Visit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
           Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(scanResult));
           startActivity(intent);
            }
        });*/

        builder.setMessage(scanResult);
        AlertDialog alert = builder.create();
        alert.show();

    }}




    /*public void insertData(final String id) {


        StringRequest request = new StringRequest(Request.Method.POST, "https://51.136.14.11/serdar/insertdata.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.equalsIgnoreCase("Data Inserted")){

                            Toast.makeText(girendaki.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(girendaki.this, response, Toast.LENGTH_LONG).show();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(girendaki.this, error.getMessage(), Toast.LENGTH_LONG).show();

            }
        }

        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("id", id);

                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(girendaki.this);
        requestQueue.add(request);
    }
}
*/