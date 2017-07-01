package com.example.yugi.gitlabapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yugi.gitlabapp.Entity.Group;
import com.example.yugi.gitlabapp.R;
import com.example.yugi.gitlabapp.teacherActivity.GroupActivity;

import java.util.List;

/**
 * Created by yugi on 2017/6/28.
 */

public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.ViewHolder> {

    private Context mContext;

    private List<Group> mGroupList;

    public GroupAdapter(List<Group> mGroupList) {
        this.mGroupList = mGroupList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.group_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Group group = mGroupList.get(position);
                Intent intent = new Intent(mContext, GroupActivity.class);
                intent.putExtra("groupId", group.getId());
                mContext.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Group group = mGroupList.get(position);
        holder.groupId.setText("id: "+group.getId());
        holder.groupName.setText("name: "+group.getName());
    }

    @Override
    public int getItemCount() {
        return mGroupList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView groupId;
        TextView groupName;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView;
            groupId = (TextView) itemView.findViewById(R.id.group_id);
            groupName = (TextView) itemView.findViewById(R.id.group_name);
        }
    }

}
