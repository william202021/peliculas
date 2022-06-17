package com.example.peliculas.data;



import com.example.peliculas.pojo.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostInterface {
    @GET("DisneyPosters2.json")
    public Call<List<PostModel>> getPosts();
}
