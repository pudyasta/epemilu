package com.example.testapp;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    private TextView view;
    private TextView desc;
    private CircleImageView img;
    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        view = itemView.findViewById(R.id.tv_item_name);
        desc = itemView.findViewById(R.id.tv_item_deskripsi);
        img = itemView.findViewById(R.id.img_item_photo);
    }

    public CircleImageView getImg() {
        return img;
    }

    public TextView getView(){
        return view;
    }

    public TextView getDesc() {
        return desc;
    }
}