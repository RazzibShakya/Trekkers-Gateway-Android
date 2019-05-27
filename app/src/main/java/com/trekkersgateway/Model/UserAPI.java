package com.trekkersgateway.Model;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserAPI {
    @POST("createuser")
    Call<Void>addNewUser(@Body User user);

    @GET("employee/{id}")
    Call<User> getUserByUsername(@Path("username") String username);
}
