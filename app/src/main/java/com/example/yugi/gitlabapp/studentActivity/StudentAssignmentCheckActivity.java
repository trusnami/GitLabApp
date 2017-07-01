package com.example.yugi.gitlabapp.studentActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yugi.gitlabapp.R;

public class StudentAssignmentCheckActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText assignmentIdEditText;
    private EditText studentIdEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_assignment_check);
        getSupportActionBar().hide();
        Button button = (Button) findViewById(R.id.student_check_score_button);
        assignmentIdEditText = (EditText) findViewById(R.id.student_assignment_id_edit_text);
        studentIdEditText = (EditText) findViewById(R.id.student_student_id_edit_text);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.student_check_score_button:
                String assignmentId = assignmentIdEditText.getText().toString();
                String studentId = studentIdEditText.getText().toString();
//                Toast.makeText(StudentAssignmentCheckActivity.this, assignmentId+" "+studentId, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(StudentAssignmentCheckActivity.this, QuestionListActivity.class);
                intent.putExtra("assignmentId", assignmentId);
                intent.putExtra("studentId", studentId);
                startActivity(intent);
                break;
            default:
        }

    }
}
