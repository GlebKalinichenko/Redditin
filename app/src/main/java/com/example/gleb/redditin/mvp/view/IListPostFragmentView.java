package com.example.gleb.redditin.mvp.view;

import com.example.gleb.redditin.TestPostEntity;
import com.example.gleb.redditin.entities.PostEntity;

import java.util.List;

public interface IListPostFragmentView {
    void displayPostList(List<TestPostEntity> entities);
    void displayPosts(List<PostEntity> entities);
}
