package com.example.yugi.gitlabapp.teacherActivity;

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
import android.widget.Toast;

import com.example.yugi.gitlabapp.Adapter.AssignmentQuestionAdapter;
import com.example.yugi.gitlabapp.Entity.AssignmentScore;
import com.example.yugi.gitlabapp.R;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import java.util.List;

public class TeacherAssignmentQuestionActivity extends AppCompatActivity {

    private GetAssignmentTask getAssignmentTask;
    private String assignmentId;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private String username;
    private String password;
    private String responseData = null;
    private SwipeRefreshLayout swipeRefreshLayout;
    private AssignmentScore assignmentScore;
    private List<AssignmentScore.QuestionsBean> questionsList;
    private AssignmentQuestionAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_assignment_question);
        getSupportActionBar().hide();
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        username = pref.getString("username", "liuqin");
        password = pref.getString("password", "123");
        Intent intent = getIntent();
        assignmentId = intent.getStringExtra("assignmentId");
        getAssignmentTask = new GetAssignmentTask();
        getAssignmentTask.execute();

        Toast.makeText(TeacherAssignmentQuestionActivity.this,"click any card to view it's score list",Toast.LENGTH_SHORT).show();
    }

    public class GetAssignmentTask extends AsyncTask<Void, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Void... params) {
            String baseCode = username + ":" + password;
            String token = android.util.Base64.encodeToString(baseCode.getBytes(), Base64.DEFAULT);
            try {
                HttpURLConnection connection = null;
                BufferedReader reader = null;
                URL url = new URL("http://115.29.184.56:8090/api/assignment/" + assignmentId + "/score");
                connection = (HttpURLConnection) url.openConnection();
                connection.addRequestProperty("Authorization", "Basic" + " " + token);
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(8000);
                connection.setReadTimeout(8000);
                InputStream in = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(in));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                responseData = response.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (responseData != null) {
                return true;
            }
            return false;
        }

        @Override
        protected void onPostExecute(Boolean success) {
            getAssignmentTask = null;
            if (success) {
                Gson gson = new Gson();
                assignmentScore = gson.fromJson(responseData, AssignmentScore.class);
                questionsList = assignmentScore.getQuestions();
                if (questionsList.size() == 0) {
                    Toast.makeText(TeacherAssignmentQuestionActivity.this,"sorry,no questions",Toast.LENGTH_SHORT).show();
                    return;
                }
                RecyclerView recyclerView = (RecyclerView) findViewById(R.id.teacher_assignment_question_recycler_view);
                GridLayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),1);
                recyclerView.setLayoutManager(layoutManager);
                adapter = new AssignmentQuestionAdapter(assignmentScore.getQuestions());
                recyclerView.setAdapter(adapter);
            } else {
                Toast.makeText(TeacherAssignmentQuestionActivity.this,"internet connect error",Toast.LENGTH_SHORT).show();
            }

        }
    }
}
