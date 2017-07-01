package com.example.yugi.gitlabapp.studentActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.yugi.gitlabapp.Entity.Analysis;
import com.example.yugi.gitlabapp.R;
import com.example.yugi.gitlabapp.TempObjectCollection;

public class ResultActivity extends AppCompatActivity {

    private TextView score;
    private TextView metric;
    private TextView test;
    private Analysis.QuestionResultsBean.MetricDataBean metricData;
    private Analysis.QuestionResultsBean.TestResultBean testResult;
    private Analysis.QuestionResultsBean.ScoreResultBean scoreResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        getSupportActionBar().hide();
        score = (TextView) findViewById(R.id.result_score);
        metric = (TextView) findViewById(R.id.result_metricData);
        test = (TextView) findViewById(R.id.result_test);
        metricData = TempObjectCollection.metricData;
        testResult = TempObjectCollection.testResult;
        scoreResult = TempObjectCollection.scoreResult;
        score.setText("SCORE RESULT\n"+
                "git_url:"+"\n"+scoreResult.getGit_url()+"\n"+
                "score:"+scoreResult.getScore()+"\n"+
                "scored:"+scoreResult.isScored()+"\n");
        metric.setText("METRIC DATA\n"+
                "git_url:"+"\n"+metricData.getGit_url()+"\n"+
                "measured::"+metricData.isMeasured()+"\n"+
                "total_line_count:"+metricData.getTotal_line_count()+"\n"+
                "comment_line_count:"+metricData.getComment_line_count()+"\n"+
                "field_count:"+metricData.getField_count()+"\n"+
                "method_count:"+metricData.getMethod_count()+"\n"+
                "max_coc:2"+metricData.getMax_coc()+"\n");
        test.setText("TEST RESULT\n"+
                "git_url:"+"\n"+testResult.getGit_url()+"\n"+
                "compile_succeeded:"+testResult.isCompile_succeeded()+"\n"+
                "tested:"+testResult.isTested()+"\n");
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TempObjectCollection.testcasesBeanList = testResult.getTestcases();
                Intent intent = new Intent(ResultActivity.this,TestcaseActivity.class);
                startActivity(intent);
            }
        });
    }
}
