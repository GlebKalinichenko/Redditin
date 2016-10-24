package com.example.gleb.redditin;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.example.gleb.redditin.entities.PostEntity;
import com.example.gleb.redditin.entities.PostResponseEntity;
import com.example.gleb.redditin.mvp.model.IListPostFragmentModel;
import com.example.gleb.redditin.mvp.presenter.IListPostFragmentPresenter;
import com.example.gleb.redditin.mvp.view.IListPostFragmentView;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ListPostFragmentPresenter implements IListPostFragmentPresenter {
    private final String LOG_TAG = this.getClass().getCanonicalName();
    private IListPostFragmentView view;
    private IListPostFragmentModel model;
    private Context context;

    public ListPostFragmentPresenter(IListPostFragmentView view, Context context) {
        this.view = view;
        this.context = context;
        this.model = new ListPostFragmentModel(this, context);
    }

    @Override
    public void onCreate(BaseFragment fragment) {
        Log.d(LOG_TAG, "On create is called");
        fragment.setHasOptionsMenu(true);//create menu for current fragment
    }

    @Override
    public void onResume() {
        Log.d(LOG_TAG, "On resume is called");
        getPosts();
    }

    @Override
    public void onPause() {
        Log.d(LOG_TAG, "On pause is called");
    }

    @Override
    public void onDestroyView() {
        Log.d(LOG_TAG, "On destroy view is called");
    }

    /*
    * Receive test array of entities
    * */
    @Override
    public void requestTestEntities() {
        model.testPostEntities();
    }

    /*
    * Display posts on screen list of posts
    * @param List<TestPostEntity> entities        Entities for display on list
    * */
    @Override
    public void receiveTestEntities(List<TestPostEntity> entities) {
        view.displayPostList(entities);
    }

    @Override
    public void loadSettings(int containerId, FragmentActivity activity) {
        model.loadSettings(containerId, activity);
    }

    /*
    * Receive post from blog's api
    * */
    @Override
    public void getPosts() {
        model.getPosts();
    }

    /*
    * Convert from observable of list response on response on adapter
    * @param Observable<PostResponseEntity> entities        Entities of list of posts
    * */
    @Override
    public void initDisplayPosts(Observable<PostResponseEntity> entities) {
        entities.map(i -> i.getData()).map(i -> i.getChildren()).flatMap(i -> Observable.from(i)).map(i -> i.getData())
                .reduce(new ArrayList<PostEntity>(), (arr, value) -> {arr.add(value); return arr;})
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(i -> view.displayPosts(i));
    }
}
