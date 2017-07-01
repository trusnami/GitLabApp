package com.example.yugi.gitlabapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yugi.gitlabapp.Entity.Analysis;
import com.example.yugi.gitlabapp.R;
import com.example.yugi.gitlabapp.TempObjectCollection;
import com.example.yugi.gitlabapp.studentActivity.ResultActivity;

import java.util.List;

/**
 * Created by yugi on 2017/6/30.
 */

public class QuestionResultAdapter extends RecyclerView.Adapter<QuestionResultAdapter.ViewHolder>{

    private Context context;

    private List<Analysis.QuestionResultsBean> questionResultsBeanList;

    public QuestionResultAdapter(List<Analysis.QuestionResultsBean> questionResultsBeanList) {
        this.questionResultsBeanList = questionResultsBeanList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        if (context == null) {
            context = parent.getContext();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.question_result_item, parent, false);
        final QuestionResultAdapter.ViewHolder viewHolder = new QuestionResultAdapter.ViewHolder(view);
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                Analysis.QuestionResultsBean questionResultsBean = questionResultsBeanList.get(position);
                TempObjectCollection.metricData = questionResultsBean.getMetricData();
                TempObjectCollection.testResult = questionResultsBean.getTestResult();
                TempObjectCollection.scoreResult = questionResultsBean.getScoreResult();
                Intent intent = new Intent(context, ResultActivity.class);
                context.startActivity(intent);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Analysis.QuestionResultsBean questionResultsBean = questionResultsBeanList.get(position);
        holder.id.setText("id:"+questionResultsBean.getQuestionId());
        holder.title.setText("title:"+questionResultsBean.getQuestionTitle());

    }

    @Override
    public int getItemCount() {
        return questionResultsBeanList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        TextView id;
        TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView;
            id = (TextView) itemView.findViewById(R.id.question_result_id);
            title = (TextView) itemView.findViewById(R.id.question_result_title);
        }
    }
}
