package com.anton46.whatsapp_profile.views.group_member;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.anton46.whatsapp_profile.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class GroupMemberViewHolder extends RecyclerView.ViewHolder {
    private ImageView groupMemberImageView;
    private TextView groupMemberNameTextView;
    private TextView groupMemberLastSeenTextView;
    private ImageView adminImageView;

    public GroupMemberViewHolder(View itemView) {
        super(itemView);
        groupMemberImageView = itemView.findViewById(R.id.image_view_group_member_card);
        groupMemberNameTextView = itemView.findViewById(R.id.text_view_group_member_name);
        groupMemberLastSeenTextView = itemView.findViewById(R.id.text_view_group_member_last_seen);
        adminImageView = itemView.findViewById(R.id.image_view_admin);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: add onClick event to this item
            }
        });
    }

    public void setData(GroupMemberViewModel member) {
        groupMemberNameTextView.setText(member.getName());
        groupMemberLastSeenTextView.setText(member.getLastSeen());
        Glide.with(itemView.getContext())
                .load(member.getProfilePicture().getUrl())
                .apply(new RequestOptions().circleCrop())
                .into(groupMemberImageView);
        if (member.isAdmin()) {
            adminImageView.setVisibility(View.VISIBLE);
            adminImageView.bringToFront();
        }
    }
}
