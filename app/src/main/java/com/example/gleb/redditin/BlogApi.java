package com.example.gleb.redditin;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

public interface BlogApi {
    @GET("/top.json")
    List<Observable<TestPostEntity>> getPosts();
}
