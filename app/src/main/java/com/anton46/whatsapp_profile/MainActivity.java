package com.anton46.whatsapp_profile;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.anton46.whatsapp_profile.views.group_member.GroupMemberAdapter;
import com.anton46.whatsapp_profile.views.group_member.GroupMemberViewModel;
import com.anton46.whatsapp_profile.views.media.MediaAdapter;
import com.anton46.whatsapp_profile.views.media.MediaViewModel;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener{

    @Bind(R.id.toolbar_header_view)
    protected HeaderView toolbarHeaderView;

    @Bind(R.id.float_header_view)
    protected HeaderView floatHeaderView;

    @Bind(R.id.appbar)
    protected AppBarLayout appBarLayout;

    @Bind(R.id.toolbar)
    protected Toolbar toolbar;

    @Bind(R.id.edit_text_last_seen)
    protected EditText lastSeenEditText;

    @Bind(R.id.edit_text_name)
    protected EditText nameEditText;

    @Bind(R.id.text_view_bio)
    protected TextView bioTextView;

    @Bind(R.id.text_view_phone_number)
    protected TextView phoneNumberTextView;

    @Bind(R.id.text_view_username)
    protected TextView usernameTextView;

    @Bind(R.id.recycler_view_shared_media)
    protected RecyclerView recyclerView;

    @Bind(R.id.recycler_view_group_member)
    protected RecyclerView groupMemberRecyclerView;

    @Bind(R.id.text_view_notification_option)
    protected TextView notificationOptionTextView;

    @Bind(R.id.fab_call)
    protected FloatingActionButton callFab;

    @Bind(R.id.fab_message)
    protected FloatingActionButton messageFab;

    @Bind(R.id.fab_add_member)
    protected FloatingActionButton addMemberFab;

    private boolean isHideToolbarView = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        String name = "Larry Page";
        String lastSeen = "Last seen today at 7.00PM";
        initUi(name, lastSeen);
        setProfileInfo();
    }

    private void initUi(String name, String lastSeen) {
        appBarLayout.addOnOffsetChangedListener(this);
        toolbarHeaderView.bindTo(name, lastSeen);
        floatHeaderView.bindTo(name, lastSeen);
    }

    private void setProfileInfo() {
        String username = "@username";
        String phoneNumber = "09123456789";
        String bio = "my bio my bio my bio my bio!!!";
        usernameTextView.setText(username);
        phoneNumberTextView.setText(phoneNumber);
        bioTextView.setText(bio);
    }

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
        String name = nameEditText.getText().toString();
        String lastSeen = lastSeenEditText.getText().toString();
        initUi(name, lastSeen);
        ArrayList<MediaViewModel> mediaArrayList = new ArrayList<>();
        MediaAdapter adapter = new MediaAdapter(mediaArrayList);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(adapter);
        mediaArrayList.add(new MediaViewModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS9S1cddQSI1jovslj7jvSg6EFjOsn0d8O6QHsMOxKr3iOHPrrV"));
        mediaArrayList.add(new MediaViewModel("https://www.skymetweather.com//themes/skymet/images/satellite/insat/thumb-web.jpg?x=1524377804"));
        mediaArrayList.add(new MediaViewModel("https://www.zimbabweflora.co.zw/speciesdata/images/11/112960-2.jpg"));
        mediaArrayList.add(new MediaViewModel("https://www.expertafrica.com/images/area/868_l.jpg"));
        mediaArrayList.add(new MediaViewModel("https://www.malawi-music.com/images/albums/pangono.jpg"));
        mediaArrayList.add(new MediaViewModel("http://www.diveworldwide.com/images/products/shark_diving_species_whale_shark.jpg"));
        mediaArrayList.add(new MediaViewModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTHWsnPuWFJJglzJOCdqz4IB-LfkPlad79rE_A8NuhRVWpL76bC"));
        mediaArrayList.add(new MediaViewModel("https://image-cdn.neatoshop.com/styleimg/67183/none/kiwigreen/default/371936-19;1512965831i.jpg"));
        mediaArrayList.add(new MediaViewModel("https://dqgroc0ic5iei.cloudfront.net/images/GoestaReiland_DSC01125-CMSTemplate.2e16d0ba.fill-400x400_6Wso0qQ.jpg"));
        adapter.notifyDataSetChanged();
        setGroupMemberLayout(mediaArrayList);
    }

    private void setGroupMemberLayout(ArrayList<MediaViewModel> mediaArrayList) {
        ArrayList<GroupMemberViewModel> memberArrayList = new ArrayList<>();
        GroupMemberAdapter adapter = new GroupMemberAdapter(memberArrayList);
        groupMemberRecyclerView.setNestedScrollingEnabled(false);
        groupMemberRecyclerView.setAdapter(adapter);
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

    public void changeNotificationStatus(View view){
        String option = notificationOptionTextView.getText().toString();
        if(option.equals(getString(R.string.notification_status_on))){
            notificationOptionTextView.setText(R.string.notification_status_off);
        }
        else {
            notificationOptionTextView.setText(R.string.notification_status_on);
        }
    }

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

    public void onGroupButtonClicked(View view){
        addMemberFab.setVisibility(View.VISIBLE);
        callFab.setVisibility(View.GONE);
        messageFab.setVisibility(View.GONE);
    }

    public void onChatButtonClicked(View view){
        addMemberFab.setVisibility(View.GONE);
        callFab.setVisibility(View.VISIBLE);
        messageFab.setVisibility(View.VISIBLE);
    }
}
