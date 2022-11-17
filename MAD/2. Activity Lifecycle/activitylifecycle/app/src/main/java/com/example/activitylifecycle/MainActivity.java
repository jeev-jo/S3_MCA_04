package com.example.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.b).setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(i);
        });
            Toast.makeText(getApplicationContext(), "on Create", Toast.LENGTH_SHORT).show();
            Log.e(">>>>","on Create");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "on Start", Toast.LENGTH_SHORT).show();
        Log.e(">>>>","on Start");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "on Pause", Toast.LENGTH_SHORT).show();
        Log.e(">>>>","on Pause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "on Restart", Toast.LENGTH_SHORT).show();
        Log.e(">>>>","on Restart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "on Destroy", Toast.LENGTH_SHORT).show();
        Log.e(">>>>","on Destroy");
    }
}