package com.example.gleb.redditin.entities;

public class PostResponseEntity {
    private PostDataEntity data;

    public PostResponseEntity(PostDataEntity data) {
        this.data = data;
    }

    public PostDataEntity getData() {
        return data;
    }

    public void setData(PostDataEntity data) {
        this.data = data;
    }
}
