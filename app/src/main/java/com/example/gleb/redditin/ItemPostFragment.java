package com.example.gleb.redditin;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.gleb.redditin.entities.PostEntity;
import com.example.gleb.redditin.mvp.presenter.IItemPostFragmentPresenter;
import com.example.gleb.redditin.mvp.view.IItemPostFragmentView;

import java.util.ArrayList;
import java.util.List;


public class ItemPostFragment extends BaseFragment implements Toolbar.OnMenuItemClickListener, IItemPostFragmentView {
    private final String LOG_TAG = this.getClass().getCanonicalName();
    public final static String ENTITY_KEY = "EntityKey";
    private FloatingActionButton commentsButton;
    private ListView commentsListView;
    private CommentsAdapter adapter;
    private TextView descriptionText;
    private IItemPostFragmentPresenter presenter = new ItemPostPresenter(this);

    public static ItemPostFragment getInstance(PostEntity entity) {
        ItemPostFragment fragment = new ItemPostFragment();

        Bundle args = new Bundle();
        args.putSerializable(ENTITY_KEY, entity);
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_post, container, false);
        PostEntity entity = (PostEntity) getArguments().getSerializable(ENTITY_KEY);

        initWidgets(view);
        //initContent(entity);
        initCommentsBottomSheet(view);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter.onCreate(this);
    }

    @Override
    void initWidgets(View view) {
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.menu_item_post);
        toolbar.setOnMenuItemClickListener(this);

        commentsButton = (FloatingActionButton) view.findViewById(R.id.comments_fab);
        commentsListView = (ListView) view.findViewById(R.id.commentsList);
        descriptionText = (TextView) view.findViewById(R.id.item_description_text);
    }

    private void initCommentsBottomSheet(View view){
        LinearLayout layout = (LinearLayout) view.findViewById(R.id.comments_bottom_sheet);

        BottomSheetBehavior behavior = BottomSheetBehavior.from(layout);
        CommentsBottomSheetCallback callback = new CommentsBottomSheetCallback(commentsButton);
        behavior.setBottomSheetCallback(callback);


        Context context = getActivity();

        TestPostEntity entity = new TestPostEntity("Gleb Kalinichenko", "Are you like English", "I like English");
        List<TestPostEntity> entities = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            entities.add(entity);
        }

        adapter = new CommentsAdapter(entities, context);
        commentsListView.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        presenter.onDestroyView();
        super.onDestroyView();
    }

    /*
        * Init content of item post fragment
        * @param TestPostEntity        Entity that is stored all description of post
        * */
    private void initContent(TestPostEntity entity){
        String author = entity.getAuthor();
        String title = entity.getTitle();
        String description = entity.getText();

        descriptionText.setText(description);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_help: {
                Log.d(LOG_TAG, "Menu help is clicked");
                break;
            }
        }

        return false;
    }
}
