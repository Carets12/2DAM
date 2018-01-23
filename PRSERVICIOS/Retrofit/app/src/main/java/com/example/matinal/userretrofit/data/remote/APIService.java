package com.example.matinal.userretrofit.data.remote;

import com.example.matinal.userretrofit.data.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by matinal on 18/01/2018.
 */

public interface APIService {
    @POST("./users")
    Call<User> savePost(@Body User User);
/*
    @GET("users/{email}")
    Call<List<User>> list;*/

}
