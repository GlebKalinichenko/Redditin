package com.example.gleb.redditin;

import android.content.Context;
import android.os.Build;
import android.util.Log;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

public class BlogApiService {
    private final String LOG_TAG = this.getClass().getCanonicalName();
    private Context context;
    private static BlogApiService instance = null;
    private Retrofit retrofit;
    private BlogApi api;//api for receive posts

    public static BlogApiService getInstance(Context context) {
        if (instance == null){
            instance = new BlogApiService(context);
        }
        return instance;
    }

    private BlogApiService(Context context) {
        this.context = context;
    }

    /*
    * Initialize api for receive posts of blog
    * */
    public void initBlogReceiverApi(){
        retrofit = new Retrofit.Builder().baseUrl(BuildApiUtil.API_PATH).addConverterFactory(GsonConverterFactory.create()).build();
        api = retrofit.create(BlogApi.class);
    }

    /*
    * Receive posts from blog api
    * */
    public List<Observable<TestPostEntity>> getPosts(){
        Log.d(LOG_TAG, "Posts was received");
        List<Observable<TestPostEntity>> entities = api.getPosts();
        return entities;
    }
}
