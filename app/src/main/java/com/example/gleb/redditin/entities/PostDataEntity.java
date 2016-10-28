package com.example.gleb.redditin.entities;

import java.util.List;

public class PostDataEntity {
    private List<PostChildrenEntity> children;
    private String after;
    private String before;

    public PostDataEntity(List<PostChildrenEntity> children, String after, String before) {
        this.children = children;
        this.after = after;
        this.before = before;
    }

    public List<PostChildrenEntity> getChildren() {
        return children;
    }

    public void setChildren(List<PostChildrenEntity> children) {
        this.children = children;
    }

    public String getAfter() {
        return after;
    }

    public void setAfter(String after) {
        this.after = after;
    }

    public String getBefore() {
        return before;
    }

    public void setBefore(String before) {
        this.before = before;
    }
}
