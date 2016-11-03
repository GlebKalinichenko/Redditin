package com.example.gleb.redditin.mvp.presenter;

import android.support.v4.app.FragmentActivity;
import android.view.ActionMode;

import com.example.gleb.redditin.BaseFragment;
import com.example.gleb.redditin.ListPostAdapter;
import com.example.gleb.redditin.ListPostFragment;
import com.example.gleb.redditin.OnClickEvent;
import com.example.gleb.redditin.OnClickLongEvent;
import com.example.gleb.redditin.TestPostEntity;
import com.example.gleb.redditin.entities.PostResponseEntity;

import java.util.List;

import rx.Observable;

public interface IListPostFragmentPresenter {
    void onCreate(BaseFragment fragment);
    void onResume();
    void onPause();
    void onDestroyView();
    void requestTestEntities();
    void receiveTestEntities(List<TestPostEntity> entities);
    void loadSettings(int containerId, FragmentActivity activity);
    void getPosts();
    void initDisplayPosts(Observable<PostResponseEntity> entities);
    ActionMode loadActionMode(ListPostFragment.MultipleChoiceCallback callback, FragmentActivity activity);
    void loadItemPost(ActionMode actionMode, OnClickEvent event);
    void deleteItemPost(OnClickLongEvent event, ListPostAdapter adapter, ActionMode actionMode);
}
