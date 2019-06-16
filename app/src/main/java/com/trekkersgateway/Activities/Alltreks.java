package com.trekkersgateway.Activities;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trekkersgateway.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Alltreks extends Fragment {


    public Alltreks() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_alltreks, container, false);
        ((Dashboard) getActivity())
                .setActionBarTitle("Trek List");
        return view;
    }

}
