package com.trekkersgateway.Model;


import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface UserAPI {
    //for registering user
    @POST("createuser")
    Call<Void>addNewUser(@Body User user);

    @POST("feed")
    Call<Void> addFeed(@Body Feed feed);

   //for login
    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse>checkUser(@Field("username")String username,@Field("password")String password);


    //this is a post method which will upload pic to server or API
    @Multipart
    @POST("uploadpic")
    Call<ImageFile> uploadImage(@Part MultipartBody.Part body);

}
