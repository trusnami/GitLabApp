package com.example.yugi.gitlabapp;

/**
 * Created by yugi on 2017/6/28.
 */

public class Question {

    private String id;

    private String title;

    private String description;

    private String difficulty;

    private String gitUrl;

    private String type;

    private Creator creator;

    private String duration;

    private String link;

    private String knowledgeVos;

    public Question(String id, String title, String description, String difficulty, String gitUrl,
                    String type, Creator creator, String duration, String link, String knowledgeVos) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.difficulty = difficulty;
        this.gitUrl = gitUrl;
        this.type = type;
        this.creator = creator;
        this.duration = duration;
        this.link = link;
        this.knowledgeVos = knowledgeVos;
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

    public String getDifficulty() {
        return difficulty;
    }

    public String getGitUrl() {
        return gitUrl;
    }

    public String getType() {
        return type;
    }

    public Creator getCreator() {
        return creator;
    }

    public String getDuration() {
        return duration;
    }

    public String getLink() {
        return link;
    }

    public String getKnowledgeVos() {
        return knowledgeVos;
    }
}
