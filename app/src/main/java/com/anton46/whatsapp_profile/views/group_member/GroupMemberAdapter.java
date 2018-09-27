package com.anton46.whatsapp_profile.views.group_member;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anton46.whatsapp_profile.R;
import com.anton46.whatsapp_profile.views.group_member.viewHolder.GroupMemberViewHolder;
import com.anton46.whatsapp_profile.views.group_member.viewModel.GroupMemberViewModel;

import java.util.ArrayList;

public class GroupMemberAdapter extends RecyclerView.Adapter<GroupMemberViewHolder> {
    private ArrayList<GroupMemberViewModel> groupMemberArrayList;

    public GroupMemberAdapter(ArrayList<GroupMemberViewModel> groupMemberViewModelArrayList) {
        this.groupMemberArrayList = groupMemberViewModelArrayList;
    }
    @Override
    public GroupMemberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.group_member_card, null);
        return new GroupMemberViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GroupMemberViewHolder holder, int position) {
        GroupMemberViewModel member = groupMemberArrayList.get(position);
        holder.setData(member);
    }

    @Override
    public int getItemCount() {
        return groupMemberArrayList.size();
    }
}
