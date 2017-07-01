package com.example.yugi.gitlabapp.teacherActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.yugi.gitlabapp.Adapter.QuestionAdapter;
import com.example.yugi.gitlabapp.Entity.Exam;
import com.example.yugi.gitlabapp.R;
import com.example.yugi.gitlabapp.TempObjectCollection;

import java.util.List;

public class TeacherExamQuestionActivity extends AppCompatActivity {

    private int examId ;
    private QuestionAdapter adapter;
    private List<Exam.QuestionsBean> questionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_exam_question);
        getSupportActionBar().hide();
        Intent intent = getIntent();
        examId = intent.getIntExtra("examId", 26);
        Log.d("TeacherExamQuestion", "examId:"+ examId);
        initQuestion();
        if (questionList == null) {
            Log.d("TeacherExamQuestion", "no question");
            return;
        }
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.teacher_exam_question_recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new QuestionAdapter(questionList);
        recyclerView.setAdapter(adapter);
    }

    private void initQuestion(){
        if (questionList != null) {
            questionList.clear();
        }
//        List<Exam> examList = TempObjectCollection.examList;
//        Log.d("TeacherExamQuestion", "examList size:"+ examList.size());
//        for (int i = 0; i <examList.size(); i++){
//            Exam exam = examList.get(i);
//            Log.d("TeacherExamQuestion", "examId in examList:"+ exam.getId());
//            if (exam.getId()==examId){
//                questionList = exam.getQuestions();
//                TempObjectCollection.questionList = exam.getQuestions();
//                break;
//            }
//        }
        questionList = TempObjectCollection.exam.getQuestions();
    }

}
