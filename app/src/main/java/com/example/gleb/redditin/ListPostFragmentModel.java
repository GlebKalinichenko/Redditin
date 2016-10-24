package com.example.gleb.redditin;

import android.content.Context;
import android.support.v4.app.FragmentActivity;

import com.example.gleb.redditin.entities.PostDataEntity;
import com.example.gleb.redditin.entities.PostResponseEntity;
import com.example.gleb.redditin.mvp.model.IListPostFragmentModel;
import com.example.gleb.redditin.mvp.presenter.IListPostFragmentPresenter;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

public class ListPostFragmentModel implements IListPostFragmentModel {
    private final String LOG_TAG = this.getClass().getCanonicalName();
    private IListPostFragmentPresenter presenter;
    private BlogApiService apiService;
    private Context context;

    public ListPostFragmentModel(IListPostFragmentPresenter presenter, Context context) {
        this.presenter = presenter;
        this.context = context;
        apiService = BlogApiService.getInstance(context);
        apiService.initBlogReceiverApi();
    }

    public void testPostEntities(){
        TestPostEntity entity = new TestPostEntity("Gleb Kalinichenko", "Are you like English", "I like English");
        List<TestPostEntity> entities = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            entities.add(entity);
        }

        presenter.receiveTestEntities(entities);
    }

    @Override
    public void loadSettings(int containerId, FragmentActivity activity) {
        SettingsFragment fragment = SettingsFragment.getInstance();
        FragmentHelper helper = FragmentHelper.getInstance(activity);
        helper.replaceFragment(containerId, fragment);
    }

    /*
    * Receive posts from blog api
    * */
    @Override
    public void getPosts() {
        Observable<PostResponseEntity> posts = apiService.getPosts();
        presenter.initDisplayPosts(posts);
    }
}
