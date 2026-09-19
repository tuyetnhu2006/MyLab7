package com.example.mylab7;

import java.io.Serializable;

public class Article implements Serializable {

    private String title;
    private String content;
    private int img_cover;
    private int view;

    public Article(String title, String content, int img_cover, int view) {
        this.title = title;
        this.content = content;
        this.img_cover = img_cover;
        this.view = view;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getImg_cover() {
        return img_cover;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }
}