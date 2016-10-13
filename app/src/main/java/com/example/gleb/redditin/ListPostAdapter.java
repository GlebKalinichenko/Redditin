package com.example.gleb.redditin;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ListPostAdapter extends RecyclerView.Adapter<ListPostAdapter.ViewHolder> {
    private final String LOG_TAG = this.getClass().getCanonicalName();
    private List<TestPostEntity> entities;
    private Context context;

    public ListPostAdapter(List<TestPostEntity> entities, Context context) {
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
    public void addItem(TestPostEntity entity) {
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
        private TextView titleTextView;
        private TextView textTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
        }

        /*
        * Bind item row of list of posts with value
        * @param int position        Position of row
        * */
        public void bindWidgets(int position) {
            titleTextView = (TextView) itemView.findViewById(R.id.title_text);
            textTextView = (TextView) itemView.findViewById(R.id.description_text);

            TestPostEntity entity = entities.get(position);
            String title = entity.getTitle();
            String description = entity.getText();

            titleTextView.setText(title);
            textTextView.setText(description);
        }
    }
}
