package com.example.gleb.redditin.entities;

import java.util.List;

public class PostChildrenEntity {
    private PostEntity data;

    public PostChildrenEntity(PostEntity data) {
        this.data = data;
    }

    public PostEntity getData() {
        return data;
    }

    public void setData(PostEntity data) {
        this.data = data;
    }
}
