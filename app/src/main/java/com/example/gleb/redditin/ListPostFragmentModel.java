package com.example.gleb.redditin;

import com.example.gleb.redditin.mvp.model.IListPostFragmentModel;
import com.example.gleb.redditin.mvp.presenter.IListPostFragmentPresenter;

import java.util.ArrayList;
import java.util.List;

public class ListPostFragmentModel implements IListPostFragmentModel {
    private final String LOG_TAG = this.getClass().getCanonicalName();
    private IListPostFragmentPresenter presenter;

    public ListPostFragmentModel(IListPostFragmentPresenter presenter) {
        this.presenter = presenter;
    }

    public void testPostEntities(){
        TestPostEntity entity = new TestPostEntity("Gleb Kalinichenko", "Are you like English", "I like English");
        List<TestPostEntity> entities = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            entities.add(entity);
        }

        presenter.receiveTestEntities(entities);
    }
}
