package com.example.gleb.redditin.mvp.model;

import android.support.v4.app.FragmentActivity;

import java.util.List;

public interface IListPostFragmentModel {
    void testPostEntities();
    void loadSettings(int containerId, FragmentActivity activity);
    void getPosts();
}
