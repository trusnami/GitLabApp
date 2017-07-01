package com.example.yugi.gitlabapp.teacherActivity;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.yugi.gitlabapp.Adapter.TeacherScoreAdapter;
import com.example.yugi.gitlabapp.Entity.AssignmentScore;
import com.example.yugi.gitlabapp.R;
import com.example.yugi.gitlabapp.TempObjectCollection;

import java.util.List;

public class TeacherScoreListActivity extends AppCompatActivity {

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private String username;
    private String password;
    private List<AssignmentScore.QuestionsBean.StudentsBean> studentsBeanList;
    private TeacherScoreAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_score_list);
        getSupportActionBar().hide();
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        username = pref.getString("username", "liuqin");
        password = pref.getString("password", "123");
        studentsBeanList = TempObjectCollection.studentsBeanList;
        if (studentsBeanList == null) {
            Log.d("TeacherScoreList", "no scores");
            return;
        }
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.teacher_teacher_score_recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new TeacherScoreAdapter(studentsBeanList);
        recyclerView.setAdapter(adapter);
    }

    private void initScoreList() {

    }
}
