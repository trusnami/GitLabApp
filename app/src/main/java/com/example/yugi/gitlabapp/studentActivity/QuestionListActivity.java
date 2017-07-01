package com.example.yugi.gitlabapp.studentActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import com.example.yugi.gitlabapp.Adapter.AssignmentQuestionAdapter;
import com.example.yugi.gitlabapp.Adapter.GroupAdapter;
import com.example.yugi.gitlabapp.Adapter.QuestionResultAdapter;
import com.example.yugi.gitlabapp.Entity.Analysis;
import com.example.yugi.gitlabapp.Entity.Group;
import com.example.yugi.gitlabapp.R;
import com.example.yugi.gitlabapp.teacherActivity.TeacherAllGroupActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class QuestionListActivity extends AppCompatActivity {

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private String username;
    private String password;
    private String assignmentId;
    private String studentId;
    private String responseData = null;
    private SwipeRefreshLayout swipeRefreshLayout;
    private GetAnalysisTask getAnalysisTask;
    private QuestionResultAdapter adapter;
    private Analysis analysis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_list);
        getSupportActionBar().hide();
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        username = pref.getString("username", "nanguangtailang");
        password = pref.getString("password", "123");
        Intent intent = getIntent();
        assignmentId = intent.getStringExtra("assignmentId");
        studentId = intent.getStringExtra("studentId");

        getAnalysisTask = new GetAnalysisTask();
        getAnalysisTask.execute();
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.student_question_list_swipe_refresh);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getAnalysisTask = new GetAnalysisTask();
                getAnalysisTask.execute((Void)null);
                adapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

    }

    public class GetAnalysisTask extends AsyncTask<Void, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Void... params) {
            Log.d("TeacherAllGroupActivity", "do in CheckAllGroup");
            String baseCode = username+":"+password;
            String token = android.util.Base64.encodeToString(baseCode.getBytes(), Base64.DEFAULT);
            Log.d("TeacherAllGroupActivity", "token:"+token);
            try {
                HttpURLConnection connection = null;
                BufferedReader reader = null;
                URL url = new URL("http://115.29.184.56:8090/api/assignment/"+assignmentId+"/student/"+studentId+"/analysis");
                connection = (HttpURLConnection) url.openConnection();
                connection.addRequestProperty("Authorization", "Basic"+" "+token);
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(8000);
                connection.setReadTimeout(8000);
                InputStream in = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(in));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null){
                    response.append(line);
                }
                responseData = response.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
//            Log.d("QuestionListActivity", "responseData:"+responseData);
            if (responseData != null) {
                return true;
            }
            return false;
        }

        @Override
        protected void onPostExecute(Boolean success) {
            Log.d("TeacherAllGroupActivity", "do after CheckAllGroup");
            getAnalysisTask = null;
            if (success) {
                Gson gson = new Gson();
                analysis = gson.fromJson(responseData, Analysis.class);
                if (analysis.getQuestionResults().size() == 0) {
                    Toast.makeText(QuestionListActivity.this, "sorry ,no results", Toast.LENGTH_SHORT).show();
                    return;
                }

                RecyclerView recyclerView = (RecyclerView) findViewById(R.id.student_question_list_recycler_view);
                GridLayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 1);
                recyclerView.setLayoutManager(layoutManager);
                adapter = new QuestionResultAdapter(analysis.getQuestionResults());
                recyclerView.setAdapter(adapter);

            } else {
                Toast.makeText(QuestionListActivity.this, "internet connect error", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
