package com.example.yugi.gitlabapp;

/**
 * Created by yugi on 2017/6/28.
 */

public class StudentScore {

    private String studentId;

    private String studentName;

    private String studentNumber;

    private String score;

    private String scored;

    public StudentScore(String studentId, String studentName, String studentNumber, String score, String scored) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentNumber = studentNumber;
        this.score = score;
        this.scored = scored;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public String getScore() {
        return score;
    }

    public String getScored() {
        return scored;
    }
}
