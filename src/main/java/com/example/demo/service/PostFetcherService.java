package com.example.demo.service;

import com.example.demo.api.PostService;
import com.example.demo.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.util.List;

@Service
public class PostFetcherService {

    @Autowired
    private PostService postService;

    public Post getPostById(int id) {
        try {
            Response<Post> response = postService.getPostById(id).execute();
            return response.body();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Post> getAllPosts() {
        try {
            Response<List<Post>> response = postService.getAllPosts().execute();
            return response.body();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
