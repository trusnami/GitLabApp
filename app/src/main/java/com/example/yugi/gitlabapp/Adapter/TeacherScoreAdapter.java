package com.example.yugi.gitlabapp.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yugi.gitlabapp.Entity.AssignmentScore;
import com.example.yugi.gitlabapp.R;

import java.util.List;

/**
 * Created by yugi on 2017/6/29.
 */

public class TeacherScoreAdapter extends RecyclerView.Adapter<TeacherScoreAdapter.ViewHolder>{

    private Context mContext;
    private List<AssignmentScore.QuestionsBean.StudentsBean> studentsBeanList;

    public TeacherScoreAdapter(List<AssignmentScore.QuestionsBean.StudentsBean> studentsBeanList) {
        this.studentsBeanList = studentsBeanList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.score_item, parent, false);
        final TeacherScoreAdapter.ViewHolder viewHolder = new TeacherScoreAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        AssignmentScore.QuestionsBean.StudentsBean studentsBean = studentsBeanList.get(position);
        holder.id.setText("id:"+studentsBean.getStudentId());
        holder.scored.setText("scored:"+studentsBean.isScored());
        holder.score.setText("score:"+studentsBean.getScore());
        holder.number.setText("number:"+studentsBean.getStudentNumber());
        holder.name.setText("name:"+studentsBean.getStudentName());
    }

    @Override
    public int getItemCount() {
        return studentsBeanList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        TextView id;
        TextView name;
        TextView number;
        TextView score;
        TextView scored;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView;
            id = (TextView) itemView.findViewById(R.id.score_student_id);
            name = (TextView) itemView.findViewById(R.id.score_student_name);
            number = (TextView) itemView.findViewById(R.id.score_student_number);
            score = (TextView) itemView.findViewById(R.id.score_student_score);
            scored = (TextView) itemView.findViewById(R.id.score_student_scored);
        }
    }
}
