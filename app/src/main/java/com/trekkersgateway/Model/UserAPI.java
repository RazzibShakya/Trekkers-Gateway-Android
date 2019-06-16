package com.trekkersgateway.Model;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserAPI {
    //for registering user
    @POST("createuser")
    Call<Void>addNewUser(@Body User user);

   //for login
    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse>checkUser(@Field("username")String username,@Field("password")String password);

}
