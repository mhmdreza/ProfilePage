package com.anton46.whatsapp_profile;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.anton46.whatsapp_profile.views.fragments.BaseFragment;
import com.anton46.whatsapp_profile.views.fragments.GroupFragment;
import com.anton46.whatsapp_profile.views.fragments.UserFragment;
import com.anton46.whatsapp_profile.views.media.viewModel.MediaViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener{

    private HeaderView toolbarHeaderView;
    private HeaderView floatHeaderView;
    private AppBarLayout appBarLayout;
    private Toolbar toolbar;
    protected TextView notificationOptionTextView;
    protected FloatingActionButton firstFab;
    protected FloatingActionButton messageFab;

    private boolean isHideToolbarView = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
//        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        startFragment();
        if (isGroupProfile()){
            firstFab.setImageResource(R.drawable.ic_add_member);
            messageFab.hide();
        }else {
            firstFab.setImageResource(R.drawable.ic_call);
            messageFab.show();
        }
        String name = "محمدرضا جعفرزاده";
        String lastSeen = "آخرین بازدید دیروز";
        initUi(name, lastSeen);
//        setProfileInfo();
    }

    private void initializeViews() {
        toolbarHeaderView = findViewById(R.id.toolbar_header_view);
        floatHeaderView = findViewById(R.id.float_header_view);
        appBarLayout = findViewById(R.id.appbar);
        toolbar = findViewById(R.id.toolbar);
        firstFab = findViewById(R.id.fab1);
        messageFab = findViewById(R.id.fab_message);
        notificationOptionTextView = findViewById(R.id.text_view_notification_option);
    }

    private void startFragment() {
        BaseFragment fragment;
        if(isGroupProfile()){
            fragment = new GroupFragment();
        }else {
            fragment = new UserFragment();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_main, fragment);
        fragmentTransaction.commit();
    }

    private boolean isGroupProfile() {
        return true;
    }

    private void initUi(String name, String lastSeen) {
        appBarLayout.addOnOffsetChangedListener(this);
        toolbarHeaderView.bindTo(name, lastSeen);
        floatHeaderView.bindTo(name, lastSeen);
    }

//    private void setProfileInfo() {
//        String username = "@username";
//        String phoneNumber = "09123456789";
//        String bio = "my bio my bio my bio my bio!!!";
//        usernameTextView.setText(username);
//        phoneNumberTextView.setText(phoneNumber);
//        bioTextView.setText(bio);
//    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int offset) {
        int maxScroll = appBarLayout.getTotalScrollRange();
        float percentage = (float) Math.abs(offset) / (float) maxScroll;

        if (percentage == 1f && isHideToolbarView) {
            toolbarHeaderView.setVisibility(View.VISIBLE);
            isHideToolbarView = !isHideToolbarView;

        } else if (percentage < 1f && !isHideToolbarView) {
            toolbarHeaderView.setVisibility(View.GONE);
            isHideToolbarView = !isHideToolbarView;
        }
    }

    public void onSubmitClicked(View view) {
//        String name = nameEditText.getText().toString();
//        String lastSeen = lastSeenEditText.getText().toString();
//        initUi(name, lastSeen);
//        ArrayList<MediaViewModel> mediaArrayList = new ArrayList<>();
//        MediaAdapter adapter = new MediaAdapter(mediaArrayList);
//        recyclerView.setNestedScrollingEnabled(false);
//        recyclerView.setAdapter(adapter);
//        mediaArrayList.add(new MediaViewModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS9S1cddQSI1jovslj7jvSg6EFjOsn0d8O6QHsMOxKr3iOHPrrV"));
//        mediaArrayList.add(new MediaViewModel("https://www.skymetweather.com//themes/skymet/images/satellite/insat/thumb-web.jpg?x=1524377804"));
//        mediaArrayList.add(new MediaViewModel("https://www.zimbabweflora.co.zw/speciesdata/images/11/112960-2.jpg"));
//        mediaArrayList.add(new MediaViewModel("https://www.expertafrica.com/images/area/868_l.jpg"));
//        mediaArrayList.add(new MediaViewModel("https://www.malawi-music.com/images/albums/pangono.jpg"));
//        mediaArrayList.add(new MediaViewModel("http://www.diveworldwide.com/images/products/shark_diving_species_whale_shark.jpg"));
//        mediaArrayList.add(new MediaViewModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTHWsnPuWFJJglzJOCdqz4IB-LfkPlad79rE_A8NuhRVWpL76bC"));
//        mediaArrayList.add(new MediaViewModel("https://image-cdn.neatoshop.com/styleimg/67183/none/kiwigreen/default/371936-19;1512965831i.jpg"));
//        mediaArrayList.add(new MediaViewModel("https://dqgroc0ic5iei.cloudfront.net/images/GoestaReiland_DSC01125-CMSTemplate.2e16d0ba.fill-400x400_6Wso0qQ.jpg"));
//        adapter.notifyDataSetChanged();
//        setGroupMemberLayout(mediaArrayList);
    }

    private void setGroupMemberLayout(ArrayList<MediaViewModel> mediaArrayList) {
//        ArrayList<GroupMemberViewModel> memberArrayList = new ArrayList<>();
//        GroupMemberAdapter adapter = new GroupMemberAdapter(memberArrayList);
//        groupMemberRecyclerView.setNestedScrollingEnabled(false);
//        groupMemberRecyclerView.setAdapter(adapter);
//        memberArrayList.add(new GroupMemberViewModel("ali", "online", mediaArrayList.get(0), true));
//        memberArrayList.add(new GroupMemberViewModel("ali zdmdgfxcv", "7 minutes ago", mediaArrayList.get(1), false));
//        memberArrayList.add(new GroupMemberViewModel("ali sdt", "today 17:45", mediaArrayList.get(2), false));
//        memberArrayList.add(new GroupMemberViewModel("alixvfb f ", "yesterday 12:33", mediaArrayList.get(3), true));
//        memberArrayList.add(new GroupMemberViewModel("ali zvdglrxclv", "2018/11/11 11:11", mediaArrayList.get(4), false));
//        memberArrayList.add(new GroupMemberViewModel("ali xvc fbdb", "online", mediaArrayList.get(5), false));
//        memberArrayList.add(new GroupMemberViewModel("ali rogl; fobk;fldb, f", "10 minasdfg", mediaArrayList.get(6), false));
//        memberArrayList.add(new GroupMemberViewModel("ali dzsgr dfg;l, ldf", "online", mediaArrayList.get(7), true));
//        memberArrayList.add(new GroupMemberViewModel("ali dfmgdf l;bfd", "online", mediaArrayList.get(8), false));
//        adapter.notifyDataSetChanged();
    }

    public void onCallButtonClicked(View view) {
        Snackbar.make(view, "Call", Snackbar.LENGTH_SHORT).show();
    }

    public void onMessageButtonClicked(View view) {
        Snackbar.make(view, "Message", Snackbar.LENGTH_SHORT)
                .setAction("Action", null).show();
    }

    public void showAllSharedMedia(View view){
        Toast.makeText(this, "showAllSharedMedia", Toast.LENGTH_SHORT).show();
    }

//    public void changeNotificationStatus(View view){
//        String option = notificationOptionTextView.getText().toString();
//        if(option.equals(getString(R.string.notification_status_on))){
//            notificationOptionTextView.setText(R.string.notification_status_off);
//        }
//        else {
//            notificationOptionTextView.setText(R.string.notification_status_on);
//        }
//    }

    public void clearChatHistory(View view){
        Toast.makeText(this, "clearChatHistory", Toast.LENGTH_SHORT).show();
    }

    public void blockUser(View view){
        Toast.makeText(this, "blockUser", Toast.LENGTH_SHORT).show();
    }

    public void showAllGroupMember(View view){
        Toast.makeText(this, "showAllGroupMember", Toast.LENGTH_SHORT).show();
    }

    public void onAddMemberButtonClicked(View view) {
        Toast.makeText(this, "onAddMemberButtonClicked", Toast.LENGTH_SHORT).show();
    }

    public void onFirstFabClicked(View view) {
        if(isGroupProfile()){
            onAddMemberButtonClicked(view);
        }else {
            onCallButtonClicked(view);
        }
    }
}
