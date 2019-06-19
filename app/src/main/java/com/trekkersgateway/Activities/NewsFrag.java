package com.trekkersgateway.Activities;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trekkersgateway.Adapter.NewsRecyclerAdapter;
import com.trekkersgateway.Model.News;
import com.trekkersgateway.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFrag extends Fragment {
    RecyclerView rv;
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
        ((Dashboard) (getContext())).getSupportActionBar()
                .hide();
        rv=view.findViewById(R.id.recylerNews);
        rv.setLayoutManager(new GridLayoutManager(getContext(),3));
        rv.setAdapter(new NewsRecyclerAdapter(NewsList,((Dashboard) (getContext()))));
        return view;
    }

}
