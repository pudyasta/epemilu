package com.example.testapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Random;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Random;

public class RandomNumListAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    private Random random;
    List<DataModel> stringList;

    public RandomNumListAdapter(List<DataModel> stringList) {
        this.stringList = stringList;
    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.news_layout;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        DataModel data = stringList.get(position);
        holder.getView().setText(data.getTitle());
        holder.getDesc().setText(data.getDescription());
        holder.getImg().setBackgroundResource(data.getImg());
    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }
}
