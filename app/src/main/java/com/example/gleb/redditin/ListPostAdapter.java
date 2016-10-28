package com.example.gleb.redditin;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gleb.redditin.entities.PostEntity;

import java.util.List;

public class ListPostAdapter extends RecyclerView.Adapter<ListPostAdapter.ViewHolder> {
    private final String LOG_TAG = this.getClass().getCanonicalName();
    private List<PostEntity> entities;
    private Context context;

    public ListPostAdapter(List<PostEntity> entities, Context context) {
        this.entities = entities;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(LOG_TAG, "On create view of adapter for list posts");

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_list_post, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindWidgets(position);
    }

    @Override
    public int getItemCount() {
        return entities.size();
    }

    /*
    * Add entity for list posts
    * @param TestPostEntity entity        Pushing entity
    * */
    public void addItem(PostEntity entity) {
        entities.add(entity);
    }

    /*
    * Remove entity from list posts
    * @param TestPostEntity entity        Deleting entity
    * */
    public void removeItem(TestPostEntity entity) {
        entities.remove(entity);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private View itemView;
        private TextView authorTextView;
        private TextView titleTextView;
        private ImageView postImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
        }

        /*
        * Bind item row of list of posts with value
        * @param int position        Position of row
        * */
        public void bindWidgets(final int position) {
            authorTextView = (TextView) itemView.findViewById(R.id.author_text);
            titleTextView = (TextView) itemView.findViewById(R.id.title_text);
            postImageView = (ImageView) itemView.findViewById(R.id.post_image);

            PostEntity entity = entities.get(position);
            String title = entity.getAuthor();
            String description = entity.getTitle();

            authorTextView.setText(title);
            titleTextView.setText(description);

            itemView.setOnClickListener(i -> loadItemFragment(entity));
        }

        /*
        * Load item fragment on click on post item element
        * @param TestPostEntity        Entity of item post
        * */
        private void loadItemFragment(PostEntity entity){
            BaseFragment fragment = ItemPostFragment.getInstance(entity);
            FragmentHelper helper = FragmentHelper.getInstance((FragmentActivity) context);
            helper.replaceFragment(R.id.layout_container, fragment);
        }
    }
}
