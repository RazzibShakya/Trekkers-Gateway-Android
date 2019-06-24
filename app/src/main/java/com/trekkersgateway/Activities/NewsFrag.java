package com.trekkersgateway.Activities;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.trekkersgateway.Adapter.NewsRecyclerAdapter;
import com.trekkersgateway.Model.Functions;
import com.trekkersgateway.Model.News;
import com.trekkersgateway.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Url;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFrag extends Fragment {
    RecyclerView newsrv;
    List<News> NewsList=new ArrayList<>();
    Dashboard dashboard;

    public NewsFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        getAllNews();
        ((Dashboard) (getContext())).getSupportActionBar()
                .hide();
        newsrv=view.findViewById(R.id.recylerNews);
        newsrv.setLayoutManager(new GridLayoutManager(getContext(),3));
        newsrv.setAdapter(new NewsRecyclerAdapter(NewsList,((Dashboard) (getContext()))));
        return view;
    }

    private void getAllNews(){
        Functions function=new Functions();
        Call<List<News>> listnews=function.createInstanceofRetrofit().getAllNews();
        listnews.enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getContext(), "dasd:" + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                List<News>newslist=response.body();
                NewsRecyclerAdapter newsadapter=new NewsRecyclerAdapter(newslist,getContext());
                newsrv.setAdapter(newsadapter);
                newsrv.setLayoutManager(new GridLayoutManager(getContext(),2));
            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {
                Toast.makeText(getContext(), "abc:" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                Log.d("getallnews", t.getLocalizedMessage());
            }
        });
    }

}
