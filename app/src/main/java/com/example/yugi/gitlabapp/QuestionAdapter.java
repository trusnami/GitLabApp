package com.example.yugi.gitlabapp;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by yugi on 2017/6/29.
 */

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ViewHolder>{

    private Context mContext;

    private List<Exam.QuestionsBean> mQuestionList;

    public QuestionAdapter(List<Exam.QuestionsBean> mQuestionList) {
        this.mQuestionList = mQuestionList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.exam_question_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Exam.QuestionsBean question = mQuestionList.get(position);
        holder.id_description.setText("id:"+question.getId()+" description:"+question.getDescription());
        holder.title_difficulty.setText("title:"+question.getTitle()+" difficulty:"+question.getDifficulty());
        holder.giturl.setText("giturl:"+question.getGitUrl());
        holder.type_duration.setText("type:"+question.getType()+" duration:"+question.getDuration());
        holder.link.setText("link:"+question.getLink());
    }

    @Override
    public int getItemCount() {
        return mQuestionList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        TextView id_description;
        TextView title_difficulty;
        TextView giturl;
        TextView type_duration;
        TextView link;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView;
            id_description = (TextView) itemView.findViewById(R.id.question_id_description);
            title_difficulty = (TextView) itemView.findViewById(R.id.question_title_difficulty);
            giturl = (TextView) itemView.findViewById(R.id.question_giturl);
            type_duration = (TextView) itemView.findViewById(R.id.question_type_duration);
            link = (TextView) itemView.findViewById(R.id.question_link);
        }
    }
}
