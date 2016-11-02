package com.example.gleb.redditin;

import com.example.gleb.redditin.entities.PostEntity;

public class OnClickEvent {
    private PostEntity entity;

    public OnClickEvent(PostEntity entity) {
        this.entity = entity;
    }

    public PostEntity getEntity() {
        return entity;
    }

    public void setEntity(PostEntity entity) {
        this.entity = entity;
    }
}


