package com.example.gleb.redditin;

import com.example.gleb.redditin.entities.PostResponseEntity;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

public interface BlogApi {
    @GET("top.json")
    Observable<PostResponseEntity> getPosts();
}
