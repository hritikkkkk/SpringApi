package com.example.demo.api;

import com.example.demo.model.Post;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface PostService {
    @GET("/posts/{id}")
    Call<Post> getPostById(@Path("id") int id);

    @GET("/posts")
    Call<List<Post>> getAllPosts();
}
