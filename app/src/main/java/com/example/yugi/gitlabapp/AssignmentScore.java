package com.example.yugi.gitlabapp;

import java.util.List;

/**
 * Created by yugi on 2017/6/28.
 */

public class AssignmentScore {

    private String id;

    private List<ScoreQuestion> scoreQuestionList;

    public AssignmentScore(String id, List<ScoreQuestion> scoreQuestionList) {
        this.id = id;
        this.scoreQuestionList = scoreQuestionList;
    }

    public String getId() {
        return id;
    }

    public List<ScoreQuestion> getScoreQuestionList() {
        return scoreQuestionList;
    }
}
