package com.example.gleb.redditin.mvp.presenter;

import android.support.v4.app.FragmentActivity;

import com.example.gleb.redditin.BaseFragment;
import com.example.gleb.redditin.TestPostEntity;

import java.util.List;

public interface IListPostFragmentPresenter {
    void onCreate(BaseFragment fragment);
    void onResume();
    void onPause();
    void onDestroyView();
    void requestTestEntities();
    void receiveTestEntities(List<TestPostEntity> entities);
    void loadSettings(int containerId, FragmentActivity activity);
}
