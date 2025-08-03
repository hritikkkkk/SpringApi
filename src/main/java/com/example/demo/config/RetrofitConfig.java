package com.example.demo.config;

import com.example.demo.api.PostService;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig {

    @Bean
    public Retrofit retrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .client(new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Bean
    public PostService postService(Retrofit retrofit) {
        return retrofit.create(PostService.class);
    }
}
