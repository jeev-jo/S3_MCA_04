package com.example.login_app;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.PatternMatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText email;
    private TextInputEditText password;
    private TextInputEditText phone;

    private TextInputLayout c_email;
    private TextInputLayout c_pass;
    private TextInputLayout c_phone;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = (TextInputEditText) findViewById(R.id.e_mail);
        password = (TextInputEditText) findViewById(R.id.e_pass);
        phone = (TextInputEditText) findViewById(R.id.e_phone);

        c_email = (TextInputLayout) findViewById(R.id.c_mail);
        c_pass = (TextInputLayout) findViewById(R.id.c_pass);
        c_phone = (TextInputLayout) findViewById(R.id.c_phone);

        MaterialButton login = (MaterialButton) findViewById(R.id.b_login);
        MaterialButton reset = (MaterialButton) findViewById(R.id.b_reset);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            password.setTooltipText("Minimum 8 characters, at-least one Upper case, one Digit, one Special character - @#$%^&+=");
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onLogin();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onReset();
            }
        });
        emailInputTextOnFocusListener();
        passwordInputTextOnFocusListener();
        phoneInputTextOnFocusListener();

    }

    private String validPassword(){
        String passwordText = password.getText().toString();
        if (passwordText.length() <8)
            return "Password must be minimum 8 digit";
        if (passwordText.matches(".*[a-z].*"))
            return "Password must contain a lower case";
        if (passwordText.matches(".*[A-Z].*"))
            return "Password must contain an Upper case";
        if(passwordText.matches(".*[0-9].*"))
            return "Password must contain a number";
        if (passwordText.matches(".*[!@#$%^&*+=/?].*"))
            return "Password must contain a special character";
        return null;
    }

    private String validMail(){
        String mailinput = email.getText().toString();
        if(!Patterns.EMAIL_ADDRESS.matcher(mailinput).matches())
            return "Invalid email address";
        return null;
    }

    private String validPhone(){
        String phoneText = phone.getText().toString();
        if(!phoneText.matches(".*[0-9].*"))
            return "Phone number must be digit";
        if(phoneText.length() < 10)
            return "Phone number must be 10 digit";
        return null;
    }


    private void onLogin(){
        c_email.setHelperText(validMail());
        c_pass.setHelperText(validPassword());
        c_phone.setHelperText(validPhone());

        boolean mailvalidity = c_email.getHelperText() == null;
        boolean passvalidity = c_pass.getHelperText() == null;
        boolean phonevalidity = c_phone.getHelperText() == null;

        if ( mailvalidity && passvalidity && phonevalidity){
            Intent i = new Intent(MainActivity.this, Dashboard.class);
            startActivity(i);
            finish();

        }
        else
            Toast.makeText(this, "Invalid form", Toast.LENGTH_SHORT).show();
    }

    private void onReset(){
        email.setText("");
        password.setText("");
        phone.setText("");

        c_email.setHelperText("Required");
        c_phone.setHelperText("Required");
        c_pass.setHelperText("Required");
    }

    private void emailInputTextOnFocusListener(){
        email.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                c_email.setHelperText(validMail());
            }
        });
    }

    private void passwordInputTextOnFocusListener(){
        password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                c_pass.setHelperText(validPassword());
            }
        });
    }

    private void phoneInputTextOnFocusListener(){
        phone.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                c_phone.setHelperText(validPhone());
            }
        });
    }
}