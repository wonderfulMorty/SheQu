package com.shequ.pojo;

public class Survey {
    private int id;
    private String title;

    public Survey() {
    }

    public Survey(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Survey{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
