package com.example.gleb.redditin;

import com.example.gleb.redditin.mvp.model.IItemPostFragmentModel;
import com.example.gleb.redditin.mvp.model.IListPostFragmentModel;
import com.example.gleb.redditin.mvp.presenter.IItemPostFragmentPresenter;
import com.example.gleb.redditin.mvp.view.IItemPostFragmentView;
import com.example.gleb.redditin.mvp.view.IListPostFragmentView;

public class ItemPostPresenter implements IItemPostFragmentPresenter {
    private IItemPostFragmentView view;
    private IItemPostFragmentModel model;

    public ItemPostPresenter(IItemPostFragmentView view) {
        this.view = view;
        model = new ItemPostFragmentModel(this);
    }

    @Override
    public void onCreate(BaseFragment fragment) {
        fragment.setHasOptionsMenu(true);
    }

    @Override
    public void onDestroyView() {

    }
}
