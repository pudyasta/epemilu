package com.example.testapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AntrianActivity extends AppCompatActivity {
    private static final String BASE_URL = "https://b0d0-202-43-94-33.ngrok-free.app/";

    private ApiServices postApiService;
    private Button btn;
    private List<String> id;
    public void fetchPosts() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();
        postApiService = retrofit.create(ApiServices.class);
        Call<QueueModelData> call = postApiService.getData();
        call.enqueue(new Callback<QueueModelData>() {
            @Override
            public void onResponse(Call<QueueModelData> call, Response<QueueModelData> response) {
                System.out.println(response);
                if (response.isSuccessful()) {
                    QueueModelData posts = response.body();
                    id = posts.getQueue();
                } else {
                    // Handle unsuccessful response
                    System.out.println("posts");

                }
            }

            @Override
            public void onFailure(Call<QueueModelData> call, Throwable t) {
                // Handle network failure or error
                System.out.println("ERROORR "+t);

            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_antrian);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        btn = findViewById(R.id.buttonConstraintLayout2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAntri("Rioga");
            }
        });

        this.fetchPosts();
    }


    public void switchActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void setAntri(String data){
        NewQueueData modal = new NewQueueData(data);
        TextView text = findViewById(R.id.textView110);
        btn.setEnabled(false);


        // calling a method to create a post and passing our modal class.
        Call<NewQueueData> call = postApiService.createPost(modal);

        // on below line we are executing our method.
        call.enqueue(new Callback<NewQueueData>() {
            @Override
            public void onResponse(Call<NewQueueData> call, Response<NewQueueData> response) {
                // this method is called when we get response from our api.
                Toast.makeText(getApplicationContext(), "Sukses Menambahkan Antrian", Toast.LENGTH_SHORT).show();
                NewQueueData responseFromAPI = response.body();
                fetchPosts();
                text.setText(String.valueOf(id.size()));
                btn.setText("Sudah ambil antrian");
                btn.setEnabled(false);
                btn.setBackground(getDrawable(R.drawable.kotak));

//                text.setText(responseFromAPI.getItem());
            }

            @Override
            public void onFailure(Call<NewQueueData> call, Throwable t) {
                btn.setEnabled(true);

                Toast.makeText(getApplicationContext(), "Internal Server Error", Toast.LENGTH_SHORT).show();
            }
        });

    }

}