package com.trekkersgateway.Activities;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.gson.Gson;
import com.trekkersgateway.Model.User;
import com.trekkersgateway.R;

import java.io.Serializable;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class Profile extends Fragment {
TextView name,email,phone,dob,location;
    public Profile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        ((Dashboard) (getContext())).getSupportActionBar()
               .hide();
//        (getActivity())
//                .getActionBar().setDisplayHomeAsUpEnabled(true);
 initiate(view);



        return view;
    }

    public void initiate(View view){
name=view.findViewById(R.id.proname);
        email=view.findViewById(R.id.proemail);
        phone=view.findViewById(R.id.prophone);
        dob=view.findViewById(R.id.prodob);
        location=view.findViewById(R.id.prolocation);
        User user=((Dashboard)(getActivity())).getUser();
        name.setText(user.getName());
        email.setText(user.getEmail());
        phone.setText(user.getPhone());
        dob.setText(user.getDob());
        location.setText(user.getCountry());
    }


}
