package com.example.yugi.gitlabapp.studentActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.yugi.gitlabapp.Adapter.StudentAdapter;
import com.example.yugi.gitlabapp.Adapter.TestAdapter;
import com.example.yugi.gitlabapp.Entity.Analysis;
import com.example.yugi.gitlabapp.R;
import com.example.yugi.gitlabapp.TempObjectCollection;

import java.util.List;

public class TestcaseActivity extends AppCompatActivity {

    private TestAdapter adapter;
    private List<Analysis.QuestionResultsBean.TestResultBean.TestcasesBean> testcasesBeanList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testcase);
        getSupportActionBar().hide();
        testcasesBeanList = TempObjectCollection.testcasesBeanList;

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.testcase_toolbar_recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new TestAdapter(testcasesBeanList);
        recyclerView.setAdapter(adapter);
    }
}
