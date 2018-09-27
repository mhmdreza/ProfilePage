package com.anton46.whatsapp_profile.views.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.anton46.whatsapp_profile.R;
import com.anton46.whatsapp_profile.views.group_member.GroupMemberAdapter;
import com.anton46.whatsapp_profile.views.group_member.viewModel.GroupMemberViewModel;
import com.anton46.whatsapp_profile.views.media.viewModel.MediaViewModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class GroupFragment extends BaseFragment {

    private RecyclerView groupMemberRecyclerView;
    private TextView groupDescriptionTextView;

    public GroupFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_group, container, false);
        sharedMediaRecyclerView = view.findViewById(R.id.recycler_view_shared_media);
        groupMemberRecyclerView = view.findViewById(R.id.recycler_view_group_member);
        groupDescriptionTextView = view.findViewById(R.id.text_view_group_description);
        notificationOptionTextView = view.findViewById(R.id.text_view_notification_option);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        initializeGroupMemberLayout();
    }

    @Override
    protected void initializeViews() {
        groupDescriptionTextView.setText(R.string.group_description);
    }

    private void initializeGroupMemberLayout() {
        ArrayList<GroupMemberViewModel> memberArrayList = new ArrayList<>();
        GroupMemberAdapter adapter = new GroupMemberAdapter(memberArrayList);
        groupMemberRecyclerView.setNestedScrollingEnabled(false);
        groupMemberRecyclerView.setAdapter(adapter);
        ArrayList<MediaViewModel> mediaArrayList = new ArrayList<>();
        mediaArrayList.add(new MediaViewModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS9S1cddQSI1jovslj7jvSg6EFjOsn0d8O6QHsMOxKr3iOHPrrV"));
        mediaArrayList.add(new MediaViewModel("https://www.skymetweather.com//themes/skymet/images/satellite/insat/thumb-web.jpg?x=1524377804"));
        mediaArrayList.add(new MediaViewModel("https://www.zimbabweflora.co.zw/speciesdata/images/11/112960-2.jpg"));
        mediaArrayList.add(new MediaViewModel("https://www.expertafrica.com/images/area/868_l.jpg"));
        mediaArrayList.add(new MediaViewModel("https://www.malawi-music.com/images/albums/pangono.jpg"));
        mediaArrayList.add(new MediaViewModel("http://www.diveworldwide.com/images/products/shark_diving_species_whale_shark.jpg"));
        mediaArrayList.add(new MediaViewModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTHWsnPuWFJJglzJOCdqz4IB-LfkPlad79rE_A8NuhRVWpL76bC"));
        mediaArrayList.add(new MediaViewModel("https://image-cdn.neatoshop.com/styleimg/67183/none/kiwigreen/default/371936-19;1512965831i.jpg"));
        mediaArrayList.add(new MediaViewModel("https://dqgroc0ic5iei.cloudfront.net/images/GoestaReiland_DSC01125-CMSTemplate.2e16d0ba.fill-400x400_6Wso0qQ.jpg"));
        memberArrayList.add(new GroupMemberViewModel("ali", "online", mediaArrayList.get(0), true));
        memberArrayList.add(new GroupMemberViewModel("ali zdmdgfxcv", "7 minutes ago", mediaArrayList.get(1), false));
        memberArrayList.add(new GroupMemberViewModel("ali sdt", "today 17:45", mediaArrayList.get(2), false));
        memberArrayList.add(new GroupMemberViewModel("alixvfb f ", "yesterday 12:33", mediaArrayList.get(3), true));
        memberArrayList.add(new GroupMemberViewModel("ali zvdglrxclv", "2018/11/11 11:11", mediaArrayList.get(4), false));
        memberArrayList.add(new GroupMemberViewModel("ali xvc fbdb", "online", mediaArrayList.get(5), false));
        memberArrayList.add(new GroupMemberViewModel("ali rogl; fobk;fldb, f", "10 minasdfg", mediaArrayList.get(6), false));
        memberArrayList.add(new GroupMemberViewModel("ali dzsgr dfg;l, ldf", "online", mediaArrayList.get(7), true));
        memberArrayList.add(new GroupMemberViewModel("ali dfmgdf l;bfd", "online", mediaArrayList.get(8), false));
        adapter.notifyDataSetChanged();
    }

//    public void showAllGroupMember(View view){
//        Toast.makeText(getContext(), "showAllGroupMember", Toast.LENGTH_SHORT).show();
//    }
}
