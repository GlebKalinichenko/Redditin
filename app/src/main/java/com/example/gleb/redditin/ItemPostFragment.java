package com.example.gleb.redditin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ItemPostFragment extends BaseFragment {
    private final String LOG_TAG = this.getClass().getCanonicalName();

    public static ItemPostFragment getInstance() {
        ItemPostFragment fragment = new ItemPostFragment();

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    void initWidgets() {

    }
}
