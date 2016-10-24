package com.example.gleb.redditin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

public class CommentsAdapter extends BaseAdapter {
    private final String LOG_TAG = this.getClass().getCanonicalName();
    private List<TestPostEntity> entities;
    private Context context;

    public CommentsAdapter(List<TestPostEntity> entities, Context context) {
        this.entities = entities;
        this.context = context;
    }

    @Override
    public int getCount() {
        return entities.size();
    }

    @Override
    public Object getItem(int position) {
        return entities.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        TestPostEntity entity = entities.get(position);

        if (convertView == null) {
            viewHolder = new ViewHolder();

            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.comment_item, parent, false);

            viewHolder.comment = (TextView) convertView.findViewById(R.id.comment_text);
//            viewHolder.speakerImage = (ImageView) convertView.findViewById(R.id.speaker_image);

            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.comment.setText(entity.getText());

        return convertView;
    }

    public static class ViewHolder {
        TextView comment;
        ImageView speakerImage;
    }
}
