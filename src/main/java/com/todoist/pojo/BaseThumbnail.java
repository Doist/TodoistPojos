package com.todoist.pojo;

public class BaseThumbnail {
    private String url;
    private int width;
    private int height;

    public BaseThumbnail(String url, int width, int height) {
        this.url = url;
        this.width = width;
        this.height = height;
    }

    public String getUrl() {
        return url;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
