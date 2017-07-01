package com.example.yugi.gitlabapp.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yugi.gitlabapp.Entity.Analysis;
import com.example.yugi.gitlabapp.R;

import java.util.List;

/**
 * Created by yugi on 2017/6/30.
 */

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.ViewHolder>{

    private Context context;

    private List<Analysis.QuestionResultsBean.TestResultBean.TestcasesBean> testcasesBeanList;

    public TestAdapter(List<Analysis.QuestionResultsBean.TestResultBean.TestcasesBean> testcasesBeanList) {
        this.testcasesBeanList = testcasesBeanList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (context == null) {
            context = parent.getContext();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.test_item, parent, false);
        final TestAdapter.ViewHolder holder = new TestAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Analysis.QuestionResultsBean.TestResultBean.TestcasesBean test = testcasesBeanList.get(position);
        holder.name.setText("name:"+test.getName());
        holder.passed.setText("passed:"+test.isPassed());
    }

    @Override
    public int getItemCount() {
        return testcasesBeanList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        TextView name;
        TextView passed;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView;
            name = (TextView) itemView.findViewById(R.id.test_name);
            passed = (TextView) itemView.findViewById(R.id.test_passed);
        }
    }
}
