package com.example.new_act;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onNext(View v){
        EditText e1,e2;
        e1 = (EditText) findViewById(R.id.e1);
        e2 = (EditText) findViewById(R.id.e2);
        Intent iObj;
        iObj = new Intent("activity.sec2");
        iObj.putExtra("val1",e1.getText().toString());
        iObj.putExtra("val2",e2.getText().toString());
        startActivity(iObj);
    }
}