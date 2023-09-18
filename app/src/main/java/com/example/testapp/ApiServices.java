package com.example.testapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiServices {
    @GET("queue")
    Call<QueueModelData> getData();

    @POST("enqueue")
    Call<NewQueueData> createPost(@Body NewQueueData data);

}
