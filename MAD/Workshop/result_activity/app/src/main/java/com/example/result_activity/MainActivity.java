package com.example.result_activity;

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
    public void onMax(View v){
        EditText e1,e2;
        e1 = (EditText) findViewById(R.id.t1);
        e2 = (EditText) findViewById(R.id.t2);

        Intent IS = new Intent("e.Max");
        IS.putExtra("no1", e1.getText().toString());
        IS.putExtra("no2", e2.getText().toString());
        startActivityForResult(IS,1);
    }
    @Override
    protected void onActivityResult(int rq, int rc, Intent data){
        super.onActivityResult(rq, rc, data);
        EditText e3 = (EditText) findViewById(R.id.t3);
        if(rc == RESULT_OK){
            e3.setText(data.getData().toString());
        }
    }
}