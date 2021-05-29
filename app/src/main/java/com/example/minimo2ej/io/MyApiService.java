package com.example.minimo2ej.io;



import com.example.minimo2ej.responses.Follower;
import com.example.minimo2ej.responses.UserResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MyApiService {

    @GET("users/{username}")
    Call<UserResponse> getUserInfo(@Path("username") String username );

    @GET("users/{username}/followers")
    Call<List<Follower>>getUserFollowers(@Path("username") String username);

}
