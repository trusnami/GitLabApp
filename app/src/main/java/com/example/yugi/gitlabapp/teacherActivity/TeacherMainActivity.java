package com.example.yugi.gitlabapp.teacherActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yugi.gitlabapp.LoginActivity;
import com.example.yugi.gitlabapp.R;

public class TeacherMainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_main);
//        getSupportActionBar().hide();
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        username = pref.getString("username", "liuqin");
        password = pref.getString("password", "123");
        Toolbar toolbar = (Toolbar) findViewById(R.id.teacher_main_toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.teacher_main_drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.teacher_main_nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        TextView nameTeacherView = (TextView) findViewById(R.id.name_teacher);
        Log.d("TeacherMainActivity",pref.getString("name", "Android Studio"));
//        nameTeacherView.setText(pref.getString("name", "Android Studio"));

        ImageView imageView = (ImageView) findViewById(R.id.image_teacher);

        TextView emailTeacherView = (TextView) findViewById(R.id.email_teacher);
        Log.d("TeacherMainActivity",pref.getString("email", "android.studio@android.com"));
//        emailTeacherView.setText(pref.getString("email", "android.studio@android.com"));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.teacher_main_drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.teacher_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.teacher_logout) {
            Intent intent = new Intent(TeacherMainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_teacher_group) {
            // Handle the group action
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.teacher_main_drawer_layout);
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            }
            Intent intent = new Intent(TeacherMainActivity.this, TeacherAllGroupActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_teacher_exam) {
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.teacher_main_drawer_layout);
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            }
            Intent intent = new Intent(TeacherMainActivity.this, TeacherExamActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_teacher_homework) {
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.teacher_main_drawer_layout);
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            }
            Intent intent = new Intent(TeacherMainActivity.this, TeacherHomeworkActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_teacher_exercise) {
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.teacher_main_drawer_layout);
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            }
            Intent intent = new Intent(TeacherMainActivity.this, TeacherExerciseActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_share) {
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.teacher_main_drawer_layout);
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            }
            Intent intent = new Intent(TeacherMainActivity.this, TeacherAssignmentCheckActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.teacher_main_drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        return true;
    }

}
