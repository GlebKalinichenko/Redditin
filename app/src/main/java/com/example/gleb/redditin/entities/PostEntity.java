package com.example.gleb.redditin.entities;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PostEntity implements Serializable {
    @SerializedName("author")
    private String author;
    @SerializedName("title")
    private String title;
    @SerializedName("thumbnail")
    private String thumbnail;
    @SerializedName("num_comments")
    private String num_comments;
    @SerializedName("url")
    private String url;

    public PostEntity(String author, String title, String thumbnail, String num_comments, String url) {
        this.author = author;
        this.title = title;
        this.thumbnail = thumbnail;
        this.num_comments = num_comments;
        this.url = url;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getNum_comments() {
        return num_comments;
    }

    public void setNum_comments(String num_comments) {
        this.num_comments = num_comments;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
