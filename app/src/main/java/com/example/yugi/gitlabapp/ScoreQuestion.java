package com.example.yugi.gitlabapp;

import java.util.List;

/**
 * Created by yugi on 2017/6/28.
 */

public class ScoreQuestion {

    private QuestionInfo questionInfo;

    private List<StudentScore> studentScoreList;

    public ScoreQuestion(QuestionInfo questionInfo, List<StudentScore> studentScoreList) {
        this.questionInfo = questionInfo;
        this.studentScoreList = studentScoreList;
    }

    public QuestionInfo getQuestionInfo() {
        return questionInfo;
    }

    public List<StudentScore> getStudentScoreList() {
        return studentScoreList;
    }
}
