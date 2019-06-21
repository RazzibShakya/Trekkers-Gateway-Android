package com.trekkersgateway.Adapter;

import android.content.Context;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trekkersgateway.Model.News;
import com.trekkersgateway.R;

import java.util.List;

public class NewsRecyclerAdapter extends RecyclerView.Adapter<NewsRecyclerAdapter.NewsViewHolder> {
    List<News> NewsList;
    Context context;

    public NewsRecyclerAdapter(List<News> NewsList, Context context) {
        this.NewsList = NewsList;
        this.context = context;
    }
    @NonNull
    @Override
    public NewsRecyclerAdapter.NewsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemview = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.news_sample_row, viewGroup, false);
        return new NewsViewHolder(itemview);
    }
    private void StrictMode() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }
    @Override
    public void onBindViewHolder(@NonNull NewsRecyclerAdapter.NewsViewHolder newsViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return NewsList.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
