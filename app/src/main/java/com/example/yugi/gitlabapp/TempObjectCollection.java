package com.example.yugi.gitlabapp;

import com.example.yugi.gitlabapp.Entity.Analysis;
import com.example.yugi.gitlabapp.Entity.AssignmentScore;
import com.example.yugi.gitlabapp.Entity.Exam;
import com.example.yugi.gitlabapp.Entity.Group;
import com.example.yugi.gitlabapp.Entity.Person;
import com.example.yugi.gitlabapp.Entity.Student;

import java.util.List;

/**
 * Created by yugi on 2017/6/29.
 */

public class TempObjectCollection {

    public static Exam.QuestionsBean.CreatorBean creator = null;

    public static List<Exam> examList = null;

    public static Exam exam = null;

    public static List<AssignmentScore.QuestionsBean.StudentsBean> studentsBeanList = null;

    public static Analysis.QuestionResultsBean.MetricDataBean metricData = null;

    public static Analysis.QuestionResultsBean.TestResultBean testResult = null;

    public static Analysis.QuestionResultsBean.ScoreResultBean scoreResult = null;

    public static List<Analysis.QuestionResultsBean.TestResultBean.TestcasesBean> testcasesBeanList = null;

}
