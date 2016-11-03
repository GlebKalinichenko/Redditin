package com.example.gleb.redditin;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gleb.redditin.entities.PostEntity;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import rx.Observable;

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
    public void removeItem(PostEntity entity) {
        entities.remove(entity);
    }

    public PostEntity getItem(int position) {
        PostEntity entity = entities.get(position);
        return entity;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener {
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
            itemView.setOnLongClickListener(this);

            authorTextView = (TextView) itemView.findViewById(R.id.author_text);
            titleTextView = (TextView) itemView.findViewById(R.id.title_text);
            postImageView = (ImageView) itemView.findViewById(R.id.post_image);

            displayItemContent(position);
        }

        private void displayItemContent(int position){
            PostEntity entity = entities.get(position);
            String title = entity.getAuthor();
            String description = entity.getTitle();
            String url = entity.getThumbnail();

            authorTextView.setText(title);
            titleTextView.setText(description);

            itemView.setOnClickListener(i -> loadItemFragment(entity));
            if (url != null) {
                Picasso.with(context).load(url).into(postImageView);
            }
        }

        /*
        * Load item fragment on click on post item element
        * @param TestPostEntity        Entity of item post
        * */
        private void loadItemFragment(PostEntity entity){
            OnClickEvent event = new OnClickEvent(entity);
            EventBus.getDefault().post(event);
        }

        @Override
        public boolean onLongClick(View v) {
            int position = getAdapterPosition();
            Log.d(LOG_TAG, "Multi choice is called");
            OnClickLongEvent event = new OnClickLongEvent(position);
            EventBus.getDefault().post(event);
            return true;

        }
    }
}
