package com.example.yugi.gitlabapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import android.util.Base64;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class TeacherAllGroupActivity extends AppCompatActivity {

    private CheckAllGroupTask checkAllGroupTask =null;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private String username;
    private String password;
    private List<Group> groupList = new ArrayList<>();
    private GroupAdapter adapter;
    private String responseData = null;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_all_group);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        username = pref.getString("username", "liuqin");
        password = pref.getString("password", "123");


        checkAllGroupTask = new CheckAllGroupTask();
        checkAllGroupTask.execute((Void)null);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.teacher_allgroup_swipe_refresh);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                checkAllGroupTask = new CheckAllGroupTask();
                checkAllGroupTask.execute((Void)null);
                adapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    public class CheckAllGroupTask extends AsyncTask<Void, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Void... params) {
            Log.d("TeacherAllGroupActivity", "do in CheckAllGroup");
            String baseCode = username+":"+password;
            String token = android.util.Base64.encodeToString(baseCode.getBytes(),Base64.DEFAULT);
            Log.d("TeacherAllGroupActivity", "token:"+token);
            try {
                HttpURLConnection connection = null;
                BufferedReader reader = null;
                URL url = new URL("http://115.29.184.56:8090/api/group");
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
            Log.d("TeacherAllGroupActivity", "responseData:"+responseData);
            if (responseData != null) {
                return true;
            }
            return false;
        }

        @Override
        protected void onPostExecute(Boolean success) {
            Log.d("TeacherAllGroupActivity", "do after CheckAllGroup");
            checkAllGroupTask = null;
            if (success) {
                Gson gson = new Gson();
                groupList = gson.fromJson(responseData, new TypeToken<List<Group>>(){}.getType());
                if (groupList.size() == 0){
                    Toast.makeText(TeacherAllGroupActivity.this,"unknown error",Toast.LENGTH_SHORT).show();
                    return;
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.teacher_allgroup_recycler_view);
                        GridLayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),1);
                        recyclerView.setLayoutManager(layoutManager);
                        adapter = new GroupAdapter(groupList);
                        recyclerView.setAdapter(adapter);
                    }
                });
            } else {
                Toast.makeText(TeacherAllGroupActivity.this,"internet connect error",Toast.LENGTH_SHORT).show();
            }
        }
    }



}
