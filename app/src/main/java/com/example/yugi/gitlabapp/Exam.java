package com.example.yugi.gitlabapp;

import java.util.List;

/**
 * Created by yugi on 2017/6/28.
 */

public class Exam {

    private String id;

    private String title;

    private String description;

    private String startAt;

    private String endAt;

    private List<Question> questionList;

    private String course;

    private String status;

    private String currentTime;

    public Exam(String id, String title, String description, String startAt, String endAt,
                List<Question> questionList, String course, String status, String currentTime) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.startAt = startAt;
        this.endAt = endAt;
        this.questionList = questionList;
        this.course = course;
        this.status = status;
        this.currentTime = currentTime;
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

    public String getStartAt() {
        return startAt;
    }

    public String getEndAt() {
        return endAt;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public String getCourse() {
        return course;
    }

    public String getStatus() {
        return status;
    }

    public String getCurrentTime() {
        return currentTime;
    }
}
