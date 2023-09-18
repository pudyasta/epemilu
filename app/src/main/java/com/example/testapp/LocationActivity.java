package com.example.testapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LocationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }
    public void switchActivityToMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}