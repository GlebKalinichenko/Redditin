package com.example.gleb.redditin;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ItemPostFragment extends BaseFragment implements Toolbar.OnMenuItemClickListener {
    private final String LOG_TAG = this.getClass().getCanonicalName();
    public final static String ENTITY_KEY = "EntityKey";
    private TextView descriptionText;

    public static ItemPostFragment getInstance(TestPostEntity entity) {
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
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    void initWidgets(View view) {
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.menu_item_post);
        toolbar.setOnMenuItemClickListener(this);

        descriptionText = (TextView) view.findViewById(R.id.item_description_text);
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
