package com.example.gleb.redditin;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.gleb.redditin.entities.PostEntity;
import com.example.gleb.redditin.mvp.presenter.IListPostFragmentPresenter;
import com.example.gleb.redditin.mvp.view.IListPostFragmentView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

public class ListPostFragment extends BaseFragment implements IListPostFragmentView, Toolbar.OnMenuItemClickListener {
    private final String LOG_TAG = this.getClass().getCanonicalName();
    private Context context = getActivity();
    private IListPostFragmentPresenter presenter;
    private RecyclerView postList;
    private ListPostAdapter adapter;
    private ActionMode actionMode;

    public static ListPostFragment getInstance() {
        ListPostFragment fragment = new ListPostFragment();

        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        presenter = new ListPostFragmentPresenter(this, getActivity());
        EventBus.getDefault().register(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        EventBus.getDefault().unregister(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_posts, container, false);
        initWidgets(view);
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

    /*
    * Handle on long click on list of posts for visible choice mode at toolbar
    * @param OnClickLongEvent event    Event of callback from list of post's adapter
    * */
    @Subscribe
    public void onEvent(OnClickLongEvent event){
        FragmentActivity activity = getActivity();
        MultipleChoiceCallback callback = new MultipleChoiceCallback(event);
        actionMode = presenter.loadActionMode(callback, activity);
    }

    @Subscribe
    public void onEvent(OnClickEvent event){
        presenter.loadItemPost(actionMode, event);
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

//        adapter = new ListPostAdapter(entities, context);

        postList.setAdapter(adapter);
    }

    @Override
    public void displayPosts(List<PostEntity> entities) {
        Context context = getActivity();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        postList.setLayoutManager(linearLayoutManager);
        postList.setHasFixedSize(true);

        adapter = new ListPostAdapter(entities, context);

        postList.setAdapter(adapter);
    }

    public class MultipleChoiceCallback implements ActionMode.Callback {
        private final String LOG_TAG = this.getClass().getCanonicalName();
        private OnClickLongEvent event;

        public MultipleChoiceCallback(OnClickLongEvent event) {
            this.event = event;
        }

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater menuInflater = mode.getMenuInflater();
            menuInflater.inflate(R.menu.choice_menu, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            int menuItemId = item.getItemId();

            switch (menuItemId) {
                case R.id.action_delete:
                    Log.d(LOG_TAG, "Deleted item");
                    presenter.deleteItemPost(event, adapter, actionMode);
                    break;

            }

            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            //actionMode = null;
        }
    }
}
