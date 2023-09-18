package com.example.testapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment = new HomeFragment();
    NewsFragment newsFragment = new NewsFragment();
    ProfileFragment profileFragment =new ProfileFragment();


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();
        Context ctx = this;
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();
                        return true;
                    case R.id.news:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,newsFragment).commit();

                        return true;
                    case R.id.profile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,profileFragment).commit();
                        return true;
                }
                return false;
            }
        });

    }
    public void switchActivity(View view) {
        Intent intent = new Intent(this, AntrianActivity.class);
        startActivity(intent);
    }

    public void switchActivityToLokasi(View view) {
        Intent intent = new Intent(this, LocationActivity.class);
        startActivity(intent);
    }


    public void signout(View view){
        SessionManager sessionManager = new SessionManager(getApplicationContext());
        sessionManager.clearSession();
        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
        finish();
    }
}