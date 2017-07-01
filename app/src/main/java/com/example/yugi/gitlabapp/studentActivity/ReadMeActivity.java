package com.example.yugi.gitlabapp.studentActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yugi.gitlabapp.Adapter.QuestionResultAdapter;
import com.example.yugi.gitlabapp.Entity.Analysis;
import com.example.yugi.gitlabapp.Entity.Readme;
import com.example.yugi.gitlabapp.R;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ReadMeActivity extends AppCompatActivity {

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private String username;
    private String password;
    private String assignmentId;
    private String questionId;
    private String responseData = null;
    private GetReadmeTask getReadmeTask = null;
    private String studentId;
    private Readme readme;
    private TextView readmeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_me);
        getSupportActionBar().hide();
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        username = pref.getString("username", "nanguangtailang");
        password = pref.getString("password", "123");
        Intent intent = getIntent();
        assignmentId = intent.getStringExtra("assignmentId");
        questionId = intent.getStringExtra("questionId");
        studentId = "227";
        readmeText = (TextView) findViewById(R.id.readme_text);
        getReadmeTask = new GetReadmeTask();
        getReadmeTask.execute();
    }

    public class GetReadmeTask extends AsyncTask<Void, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Void... params) {
            Log.d("TeacherAllGroupActivity", "do in CheckAllGroup");
            String baseCode = username+":"+password;
            String token = android.util.Base64.encodeToString(baseCode.getBytes(), Base64.DEFAULT);
            Log.d("TeacherAllGroupActivity", "token:"+token);
            try {
                HttpURLConnection connection = null;
                BufferedReader reader = null;
                URL url = new URL("http://115.29.184.56:8090/api/assignment/"+assignmentId+"/student/"+studentId+"/question/"+questionId);
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
            getReadmeTask = null;
            if (success) {
                Gson gson = new Gson();
                readme = gson.fromJson(responseData, Readme.class);
                if (readme ==null) {
                    Toast.makeText(ReadMeActivity.this, "sorry ,no results", Toast.LENGTH_SHORT).show();
                    return;
                }
                readmeText.setText(readme.getContent());

            } else {
                Toast.makeText(ReadMeActivity.this, "internet connect error", Toast.LENGTH_SHORT).show();
            }
        }



    }
}
