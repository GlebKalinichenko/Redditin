package com.example.gleb.redditin;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.gleb.redditin.mvp.presenter.IListPostFragmentPresenter;
import com.example.gleb.redditin.mvp.view.IListPostFragmentView;

import java.util.List;

public class ListPostFragment extends BaseFragment implements IListPostFragmentView, Toolbar.OnMenuItemClickListener {
    private final String LOG_TAG = this.getClass().getCanonicalName();
    private Context context = getActivity();
    private IListPostFragmentPresenter presenter = new ListPostFragmentPresenter(this, getActivity());
    private RecyclerView postList;
    private ListPostAdapter adapter;

    public static ListPostFragment getInstance() {
        ListPostFragment fragment = new ListPostFragment();

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_posts, container, false);
        initWidgets(view);
        presenter.requestTestEntities();
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter.onCreate(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "On resume on list fragments is loaded");
        presenter.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    void initWidgets(View view) {
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.menu_list_post);//load menu from layout
        toolbar.setOnMenuItemClickListener(this);
        postList = (RecyclerView) view.findViewById(R.id.list_posts);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_settings: {
                Log.d(LOG_TAG, "Menu settings is clicked");
                FragmentActivity activity = getActivity();
                presenter.loadSettings(R.id.layout_container, activity);
                break;
            }

            case R.id.action_search: {
                Log.d(LOG_TAG, "Menu search is clicked");
                break;
            }
        }

        return false;
    }

    @Override
    public void onDestroyView() {
        presenter.onDestroyView();
        super.onDestroyView();
    }

    /*
    * Display list of posts on recyclerview
    * @param List<TestPostEntity> entities        List of posts to display
    * */
    @Override
    public void displayPostList(List<TestPostEntity> entities) {
        Context context = getActivity();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        postList.setLayoutManager(linearLayoutManager);
        postList.setHasFixedSize(true);

        adapter = new ListPostAdapter(entities, context);

        postList.setAdapter(adapter);
    }
}
