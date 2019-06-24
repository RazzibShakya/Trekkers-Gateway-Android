package com.trekkersgateway.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.EventLogTags;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.trekkersgateway.Model.News;
import com.trekkersgateway.R;

import java.io.InputStream;
import java.net.URL;
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
        final News news = NewsList.get(i);
        String imgpath = "http://10.0.2.2:3000/news/" + news.getImagename();
        System.out.println(imgpath);
        StrictMode();
        try {
            URL ur = new URL(imgpath);
            newsViewHolder.img.setImageBitmap(BitmapFactory.decodeStream((InputStream) ur.getContent()));

        } catch (Exception e) {
            e.printStackTrace();
        }
        newsViewHolder.news_topic.setText(news.getTopic());
        newsViewHolder.news_postedby.setText("Posted by:" + news.getPostedby());
        newsViewHolder.news_createddate.setText( news.getCreatedate());
        newsViewHolder.news_description.setText( news.getDescription());
        newsViewHolder.news_link.setText( news.getLink());
        newsViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EventLogTags.Description.class);
                intent.putExtra("news_topic", news.getTopic());
                intent.putExtra("news_posted_by", news.getPostedby());
                intent.putExtra("news_created_date", news.getCreatedate());
                intent.putExtra("news_description", news.getDescription());
                intent.putExtra("news_link", news.getLink());
                intent.putExtra("news_image", news.getImagename());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return NewsList.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {

        TextView news_topic,news_postedby,news_createddate,news_description,news_link;
        ImageView img;

        public NewsViewHolder(@NonNull View newsView) {
            super(newsView);
            news_topic=newsView.findViewById(R.id.newsrvtopic);
            news_postedby=newsView.findViewById(R.id.newsrvpostedby);
            news_createddate=newsView.findViewById(R.id.newsrvcreateddate);
            news_description=newsView.findViewById(R.id.newsrvdescription);
            news_link=newsView.findViewById(R.id.newsrvlink);
            img=newsView.findViewById(R.id.newsrvimg);
        }
    }
}
