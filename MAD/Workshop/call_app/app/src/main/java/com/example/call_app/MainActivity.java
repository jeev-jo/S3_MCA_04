package com.example.call_app;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onCall(View v){
        Intent in = new Intent(Intent.ACTION_CALL, Uri.parse("tel:9645482977"));
        try {
            startActivity(in);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}