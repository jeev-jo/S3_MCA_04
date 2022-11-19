package com.example.login_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class Dashboard extends AppCompatActivity {

    TextInputEditText first,second,dob,place,phone;
    CDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        first = (TextInputEditText) findViewById(R.id.first);
        second = (TextInputEditText) findViewById(R.id.second);
        dob = (TextInputEditText) findViewById(R.id.dob);
        place = (TextInputEditText) findViewById(R.id.place);
        phone = (TextInputEditText) findViewById(R.id.phone);
        db = new CDB(this);
    }

    public void onInsert(View v){
        String f,s,d,pl,ph;
        f = first.getText().toString();
        s = second.getText().toString();
        d = dob.getText().toString();
        pl = place.getText().toString();
        ph = phone.getText().toString();
        db.addContact(f,s,d,pl,Integer.parseInt(ph));
        Reset();
    }

    public void onUpdate(View v){
        String f,s,d,pl,ph;
        f = first.getText().toString();
        s = second.getText().toString();
        d = dob.getText().toString();
        pl = place.getText().toString();
        ph = phone.getText().toString();
        db.update(f,s,d,pl,Integer.parseInt(ph));
        Reset();
    }

    public void onDelete(View v){
        String ph = phone.getText().toString();
        db.delete(Integer.parseInt(ph));
        Reset();
    }

    public void onSearch(View v){
        String a[] = new String[0];
        try {
            String ph = phone.getText().toString();
            db.getContact(Integer.parseInt(ph));
            if (a[0] != ""){
                first.setText(a[0]);
                second.setText(a[1]);
                dob.setText(a[2]);
                place.setText(a[3]);
            }
            else
                Toast.makeText(this,"Nothing Found !!!",Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){

        }
    }

    public void onReset(View v){
        first.setText("");
        second.setText("");
        dob.setText("");
        place.setText("");
        phone.setText("");
    }
    public void Reset(){
        first.setText("");
        second.setText("");
        dob.setText("");
        place.setText("");
        phone.setText("");
    }
}