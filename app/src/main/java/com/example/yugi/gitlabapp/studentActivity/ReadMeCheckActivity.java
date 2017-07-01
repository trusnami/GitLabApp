package com.example.yugi.gitlabapp.studentActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.yugi.gitlabapp.R;

public class ReadMeCheckActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText assignmentIdEditText;
    private EditText questionIdEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_me_check);
        getSupportActionBar().hide();
        Button button = (Button) findViewById(R.id.student_readme_score_button);
        assignmentIdEditText = (EditText) findViewById(R.id.student_readme_assignment_id_edit_text);
        questionIdEditText = (EditText) findViewById(R.id.student_readme_qeustion_id_edit_text);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.student_readme_score_button:
                String assignmentId = assignmentIdEditText.getText().toString();
                String questionId = questionIdEditText.getText().toString();
                Intent intent = new Intent(ReadMeCheckActivity.this, ReadMeActivity.class);
                intent.putExtra("assignmentId", assignmentId);
                intent.putExtra("questionId", questionId);
                startActivity(intent);
                break;
            default:
        }


    }
}
