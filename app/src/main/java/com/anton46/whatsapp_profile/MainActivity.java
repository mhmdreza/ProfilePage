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

public class MainActivity extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener {

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
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        startFragment();
        if (isGroupProfile()) {
            firstFab.setImageResource(R.drawable.ic_add_member);
            messageFab.hide();
        } else {
            firstFab.setImageResource(R.drawable.ic_call);
            messageFab.show();
        }
        String name = "محمدرضا جعفرزاده";
        String lastSeen = "آخرین بازدید دیروز";
        initUi(name, lastSeen);
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
        if (isGroupProfile()) {
            fragment = new GroupFragment();
        } else {
            fragment = new UserFragment();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_main, fragment);
        fragmentTransaction.commit();
    }

    private boolean isGroupProfile() {
        return false;
    }

    private void initUi(String name, String lastSeen) {
        appBarLayout.addOnOffsetChangedListener(this);
        toolbarHeaderView.bindTo(name, lastSeen);
        floatHeaderView.bindTo(name, lastSeen);
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

    public void onCallButtonClicked(View view) {
        Snackbar.make(view, "Call", Snackbar.LENGTH_SHORT).show();
    }

    public void onMessageButtonClicked(View view) {
        Snackbar.make(view, "Message", Snackbar.LENGTH_SHORT)
                .setAction("Action", null).show();
    }

    public void showAllSharedMedia(View view) {
        Toast.makeText(this, "showAllSharedMedia", Toast.LENGTH_SHORT).show();
    }

    public void clearChatHistory(View view) {
        Toast.makeText(this, "clearChatHistory", Toast.LENGTH_SHORT).show();
    }

    public void blockUser(View view) {
        Toast.makeText(this, "blockUser", Toast.LENGTH_SHORT).show();
    }

    public void showAllGroupMember(View view) {
        Toast.makeText(this, "showAllGroupMember", Toast.LENGTH_SHORT).show();
    }

    public void onAddMemberButtonClicked(View view) {
        Toast.makeText(this, "onAddMemberButtonClicked", Toast.LENGTH_SHORT).show();
    }

    public void onFirstFabClicked(View view) {
        if (isGroupProfile()) {
            onAddMemberButtonClicked(view);
        } else {
            onCallButtonClicked(view);
        }
    }
}
