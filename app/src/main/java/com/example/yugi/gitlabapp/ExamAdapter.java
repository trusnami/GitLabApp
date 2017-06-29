package com.example.yugi.gitlabapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by yugi on 2017/6/28.
 */

public class ExamAdapter extends RecyclerView.Adapter<ExamAdapter.ViewHolder> {

    private Context mContext;

    private List<Exam> mExamList;

    public ExamAdapter(List<Exam> mExamList) {
        this.mExamList = mExamList;
    }

    @Override
    public ExamAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.exam_item, parent, false);
        final ExamAdapter.ViewHolder holder = new ExamAdapter.ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Exam exam = mExamList.get(position);
                Intent intent = new Intent(mContext, TeacherExamQuestionActivity.class);
                intent.putExtra("examId", exam.getId());
                mContext.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ExamAdapter.ViewHolder holder, int position) {
        Exam exam = mExamList.get(position);
        holder.examId.setText("id: "+exam.getId());
        holder.examTitle.setText("title: "+exam.getTitle());
        holder.description.setText("description: "+exam.getDescription());
        holder.startAt.setText("startAt: "+exam.getStartAt());
        holder.endAt.setText("endAt: "+exam.getEndAt());
        holder.course.setText("course: "+exam.getCourse());
        holder.status.setText("status: "+exam.getStatus());
        holder.currentTime.setText("currentTime: "+exam.getCurrentTime());
    }

    @Override
    public int getItemCount() {
        return mExamList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView examId;
        TextView examTitle;
        TextView description;
        TextView startAt;
        TextView endAt;
        TextView course;
        TextView status;
        TextView currentTime;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView;
            examId = (TextView) itemView.findViewById(R.id.exam_id);
            examTitle = (TextView) itemView.findViewById(R.id.exam_title);
            description = (TextView) itemView.findViewById(R.id.exam_description);
            startAt = (TextView) itemView.findViewById(R.id.exam_startAt);
            endAt = (TextView) itemView.findViewById(R.id.exam_endAt);
            course = (TextView) itemView.findViewById(R.id.exam_course);
            status = (TextView) itemView.findViewById(R.id.exam_status);
            currentTime = (TextView) itemView.findViewById(R.id.exam_currentTime);
        }
    }

}
