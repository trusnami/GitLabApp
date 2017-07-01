package com.example.yugi.gitlabapp.teacherActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yugi.gitlabapp.R;

public class TeacherAssignmentCheckActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_assignment_check);
        getSupportActionBar().hide();
        Button button = (Button) findViewById(R.id.check_score_button);
        editText = (EditText) findViewById(R.id.assignment_check_edit_text);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.check_score_button:
                String inputText = editText.getText().toString();
                Toast.makeText(TeacherAssignmentCheckActivity.this, inputText, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(TeacherAssignmentCheckActivity.this, TeacherAssignmentQuestionActivity.class);
                intent.putExtra("assignmentId", inputText);
                startActivity(intent);
                break;
            default:
        }
    }
}
