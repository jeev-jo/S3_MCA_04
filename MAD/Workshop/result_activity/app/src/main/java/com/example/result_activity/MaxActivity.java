package com.example.result_activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MaxActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        processMax();
        finish();
    }
    public void processMax(){
        Intent I;
        I = getIntent();
        Bundle B;
        B = I.getExtras();
        int a,b;
        a = Integer.parseInt(B.getString("no1"));
        b = Integer.parseInt(B.getString("no2"));
        int m = a>b ? a:b;
        Intent IR = new Intent();
        IR.setData(Uri.parse(""+m));
        setResult(RESULT_OK,IR);
    }

}