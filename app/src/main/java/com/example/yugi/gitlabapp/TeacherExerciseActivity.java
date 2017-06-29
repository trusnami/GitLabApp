package com.example.yugi.gitlabapp;

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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class TeacherExerciseActivity extends AppCompatActivity {

    private GetExerciseTask getExerciseTask;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private String username;
    private String password;
    private String courseId;
    private List<Exam> examList;
    private ExamAdapter adapter;
    private String responseData = null;
    private SwipeRefreshLayout swipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_exam);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        username = pref.getString("username", "liuqin");
        password = pref.getString("password", "123");
        courseId = "2";

        getExerciseTask = new GetExerciseTask();
        getExerciseTask.execute();
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.teacher_exam_swipe_refresh);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getExerciseTask = new GetExerciseTask();
                getExerciseTask.execute((Void)null);
                adapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    public class GetExerciseTask extends AsyncTask<Void, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Void... params) {
            String baseCode = username + ":" + password;
            String token = android.util.Base64.encodeToString(baseCode.getBytes(), Base64.DEFAULT);
            try {
                HttpURLConnection connection = null;
                BufferedReader reader = null;
                URL url = new URL("http://115.29.184.56:8090/api/course/" + courseId + "/exercise");
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
            getExerciseTask = null;
            if (success) {
                Gson gson = new Gson();
                examList = gson.fromJson(responseData, new TypeToken<List<Exam>>(){}.getType());
                if (examList.size() == 0){
                    Toast.makeText(TeacherExerciseActivity.this,"sorry,no exams",Toast.LENGTH_SHORT).show();
                    return;
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.teacher_exam_recycler_view);
                        GridLayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),2);
                        recyclerView.setLayoutManager(layoutManager);
                        adapter = new ExamAdapter(examList);
                        recyclerView.setAdapter(adapter);
                    }
                });
            } else {
                Toast.makeText(TeacherExerciseActivity.this,"internet connect error",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
