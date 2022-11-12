package com.example.new_act;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        Bundle bObj = getIntent().getExtras();
        String a = bObj.getString("val1");
        String b = bObj.getString("val2");
        EditText e2;
        e2 = (EditText) findViewById(R.id.e2);
        e2.setText(a+"   "+b);

    }
    public void onHide(View v){
        finish();
    }
}