package com.example.gleb.redditin;

import android.support.v4.app.FragmentActivity;

import com.example.gleb.redditin.mvp.model.IItemPostFragmentModel;
import com.example.gleb.redditin.mvp.presenter.IItemPostFragmentPresenter;
import com.example.gleb.redditin.mvp.presenter.IListPostFragmentPresenter;

import java.util.ArrayList;
import java.util.List;

public class ItemPostFragmentModel implements IItemPostFragmentModel {
    private final String LOG_TAG = this.getClass().getCanonicalName();
    private IItemPostFragmentPresenter presenter;

    public ItemPostFragmentModel(IItemPostFragmentPresenter presenter) {
        this.presenter = presenter;
    }

    public void testPostEntities(){
        TestPostEntity entity = new TestPostEntity("Gleb Kalinichenko", "Are you like English", "I like English");
        List<TestPostEntity> entities = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            entities.add(entity);
        }

//        presenter.receiveTestEntities(entities);
    }
}
