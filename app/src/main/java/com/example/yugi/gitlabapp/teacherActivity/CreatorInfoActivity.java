package com.example.yugi.gitlabapp.teacherActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.yugi.gitlabapp.Entity.Exam;
import com.example.yugi.gitlabapp.R;
import com.example.yugi.gitlabapp.TempObjectCollection;

public class CreatorInfoActivity extends AppCompatActivity {

    private Exam.QuestionsBean.CreatorBean creator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creator_info);
        creator = TempObjectCollection.creator;
//        getSupportActionBar().hide();

//        TextView id = (TextView) findViewById(R.id.creator_id);
//        TextView username = (TextView) findViewById(R.id.creator_username);
//        TextView name = (TextView) findViewById(R.id.creator_name);
//        TextView type = (TextView) findViewById(R.id.creator_type);
//        TextView gender = (TextView) findViewById(R.id.creator_gender);
//        TextView email = (TextView) findViewById(R.id.creator_email);
//        TextView schoolId = (TextView) findViewById(R.id.creator_schoolId);
//        id.setText(creator.getId());
//        username.setText(creator.getUsername());
//        name.setText(creator.getName());
//        type.setText(creator.getType());
//        gender.setText(creator.getGender());
//        email.setText(creator.getEmail());
//        schoolId.setText(creator.getSchoolId());
    }

}
