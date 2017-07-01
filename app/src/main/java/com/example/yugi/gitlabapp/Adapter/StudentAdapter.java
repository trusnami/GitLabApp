package com.example.yugi.gitlabapp.Adapter;

import android.content.Context;
        import android.support.v7.widget.CardView;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yugi.gitlabapp.Entity.Student;
import com.example.yugi.gitlabapp.R;

import java.util.List;

/**
 * Created by yugi on 2017/6/28.
 */

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    private Context mContext;

    private List<Student> mStudentList;

    public StudentAdapter(List<Student> mStudentList) {
        this.mStudentList = mStudentList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
        mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.student_item, parent, false);
        return new ViewHolder(view);
        }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Student student = mStudentList.get(position);
        holder.studentId.setText("Id: "+student.getId());
        holder.studentUsername.setText("Username:" +student.getUsername());
        holder.studentName.setText("Name: "+student.getName());
        holder.studentType.setText("Type: "+student.getType());
        holder.studentAvatar.setText("Avatar: "+student.getAvatar());
        holder.studentGender.setText("Gender: "+student.getGender());
        holder.studentEmail.setText("Email: "+student.getEmail());
        holder.studentSchoolId.setText("SchoolId: "+student.getSchoolId());
        holder.studentGitId.setText("GitId: "+student.getGitId());
        holder.studentGitUsername.setText("GitUsername: "+student.getGitUsername());
        holder.studentNumber.setText("Number: "+student.getNumber());
        holder.studentGroupId.setText("GroupId: "+student.getGroupId());
        }

    @Override
    public int getItemCount() {
        return mStudentList.size();
        }

    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView studentId;
        TextView studentUsername;
        TextView studentName;
        TextView studentType;
        TextView studentAvatar;
        TextView studentGender;
        TextView studentEmail;
        TextView studentSchoolId;
        TextView studentGitId;
        TextView studentGitUsername;
        TextView studentNumber;
        TextView studentGroupId;

        public ViewHolder(View itemView) {
             super(itemView);
            cardView = (CardView) itemView;
            studentId = (TextView) itemView.findViewById(R.id.student_id);
            studentUsername = (TextView) itemView.findViewById(R.id.student_username);
            studentName = (TextView) itemView.findViewById(R.id.student_name);
            studentType = (TextView) itemView.findViewById(R.id.student_type);
            studentAvatar = (TextView) itemView.findViewById(R.id.student_avatar);
            studentGender = (TextView) itemView.findViewById(R.id.student_gender);
            studentEmail = (TextView) itemView.findViewById(R.id.student_email);
            studentSchoolId = (TextView) itemView.findViewById(R.id.student_schoolId);
            studentGitId = (TextView) itemView.findViewById(R.id.student_gitId);
            studentGitUsername = (TextView) itemView.findViewById(R.id.student_gitUsername);
            studentNumber = (TextView) itemView.findViewById(R.id.student_number);
            studentGroupId = (TextView) itemView.findViewById(R.id.student_groupId);
        }
    }

}
