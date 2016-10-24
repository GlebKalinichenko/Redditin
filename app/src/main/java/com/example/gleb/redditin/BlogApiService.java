package com.example.gleb.redditin;

import android.content.Context;
import android.util.Log;
import com.example.gleb.redditin.entities.PostResponseEntity;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
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
        retrofit = new Retrofit.Builder().baseUrl(BuildApiUtil.API_PATH).addConverterFactory(GsonConverterFactory.create()).
                addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        api = retrofit.create(BlogApi.class);
    }

    /*
    * Receive posts from blog api
    * */
    public Observable<PostResponseEntity> getPosts(){
        Log.d(LOG_TAG, "Posts was received");

        Observable<PostResponseEntity> entities = api.getPosts();
        return entities;
    }
}
