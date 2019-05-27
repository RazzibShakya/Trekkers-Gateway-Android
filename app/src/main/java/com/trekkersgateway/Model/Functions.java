package com.trekkersgateway.Model;

import android.content.SharedPreferences;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Functions {
    private UserAPI userAPI;


    public UserAPI createInstanceofRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        userAPI = retrofit.create(UserAPI.class);
      return userAPI;
    }
}


