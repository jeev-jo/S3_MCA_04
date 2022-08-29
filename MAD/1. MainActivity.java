package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {
    int  f,s,r;
    TextView mine,mera;
    EditText   tum;
    Random rand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rand = new Random();
        setContentView(R.layout.activity_main);
        mine=findViewById(R.id.textView2);
        mera=findViewById(R.id.textView);
        tum=findViewById(R.id.ht);
        f= Integer.parseInt(mine.getText().toString());
        s= Integer.parseInt(mera.getText().toString());


        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(TextUtils.isEmpty(tum.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Empty Box",Toast.LENGTH_LONG).show();

                }else {
                    r= Integer.parseInt(tum.getText().toString());
                    if ((f+s)==r){
                    Toast.makeText(getApplicationContext(),"you win...",Toast.LENGTH_LONG).show();
                    mine.setText(""+ rand.nextInt(100));
                    mera.setText(""+ rand.nextInt(100));
                    }else {
                    Toast.makeText(getApplicationContext(),"you lose...",Toast.LENGTH_LONG).show();
                    }


                }
            }
        });







    }
}