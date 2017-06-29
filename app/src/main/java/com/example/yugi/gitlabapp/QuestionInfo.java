package com.example.yugi.gitlabapp;

/**
 * Created by yugi on 2017/6/28.
 */

public class QuestionInfo {
    private String id;

    private String title;

    private String description;

    private String type;

    public QuestionInfo(String id, String title, String description, String type) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }
}
