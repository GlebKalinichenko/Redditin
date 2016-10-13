package com.example.gleb.redditin;

import java.io.Serializable;

public class TestPostEntity implements Serializable {
    private String author;
    private String title;
    private String text;

    public TestPostEntity(String author, String title, String text) {
        this.author = author;
        this.title = title;
        this.text = text;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
