package com.example.testapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SignInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SessionManager sessionManager = new SessionManager(getApplicationContext());
        String username = sessionManager.getUsername();
        if (username == null){
            setContentView(R.layout.activity_sign_in);
            ActionBar actionBar = getSupportActionBar();
            actionBar.hide();
        }else{
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }

    }

    public void switchActivity(View view) {
        EditText x = findViewById(R.id.textViewpass1);
        String val = x.getText().toString();
        EditText uname = findViewById(R.id.unameid);
        String valUname = uname.getText().toString();
        System.out.println(val);
        System.out.println(val);
        if (val.equals("12345") && valUname.equals("rioga")){
            Intent intent = new Intent(this, MainActivity.class);
            SessionManager sessionManager = new SessionManager(getApplicationContext());
            sessionManager.saveUsername(valUname);
            startActivity(intent);
            finish();
        }else{
            Toast.makeText(getApplicationContext(),"User Tidak dikenali",Toast.LENGTH_SHORT).show();
        }

    }
}