package com.example.yugi.gitlabapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yugi.gitlabapp.Entity.AssignmentScore;
import com.example.yugi.gitlabapp.R;
import com.example.yugi.gitlabapp.teacherActivity.TeacherScoreListActivity;
import com.example.yugi.gitlabapp.TempObjectCollection;

import java.util.List;

/**
 * Created by yugi on 2017/6/29.
 */

public class AssignmentQuestionAdapter extends RecyclerView.Adapter<AssignmentQuestionAdapter.ViewHolder>{

    private Context mContext;

    private List<AssignmentScore.QuestionsBean> mQuestionLsit;

    public AssignmentQuestionAdapter(List<AssignmentScore.QuestionsBean> mQuestionLsit) {
        this.mQuestionLsit = mQuestionLsit;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.assignment_question_item, parent, false);
        final AssignmentQuestionAdapter.ViewHolder holder = new AssignmentQuestionAdapter.ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                AssignmentScore.QuestionsBean questionsBean = mQuestionLsit.get(position);
                TempObjectCollection.studentsBeanList = questionsBean.getStudents();
                Intent intent = new Intent(mContext, TeacherScoreListActivity.class);
                mContext.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(AssignmentQuestionAdapter.ViewHolder holder, int position) {
        AssignmentScore.QuestionsBean question = mQuestionLsit.get(position);
        holder.id.setText("id:"+question.getQuestionInfo().getId());
        holder.title.setText("title:"+question.getQuestionInfo().getTitle());
        holder.description.setText("description:"+question.getQuestionInfo().getDescription());
        holder.type.setText("type:"+question.getQuestionInfo().getType());
    }

    @Override
    public int getItemCount() {
        return mQuestionLsit.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        TextView id;
        TextView title;
        TextView description;
        TextView type;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView;
            id = (TextView) itemView.findViewById(R.id.assignment_question_id);
            title = (TextView) itemView.findViewById(R.id.assignment_question_title);
            description = (TextView) itemView.findViewById(R.id.assignment_question_description);
            type = (TextView) itemView.findViewById(R.id.assignment_question_type);
        }
    }
}
