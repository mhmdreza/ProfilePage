package com.anton46.whatsapp_profile;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.anton46.whatsapp_profile.listeners.MediaListener;
import com.anton46.whatsapp_profile.views.MediaAdapter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener, MediaListener{

    @Bind(R.id.toolbar_header_view)
    protected HeaderView toolbarHeaderView;

    @Bind(R.id.float_header_view)
    protected HeaderView floatHeaderView;

    @Bind(R.id.appbar)
    protected AppBarLayout appBarLayout;

    @Bind(R.id.toolbar)
    protected Toolbar toolbar;

//    @Bind(R.id.edit_text_last_seen)
//    protected EditText lastSeenEditText;
//
//    @Bind(R.id.edit_text_name)
//    protected EditText nameEditText;

//    @Bind(R.id.text_view_bio)
//    protected TextView bioTextView;
//
//    @Bind(R.id.text_view_phone_number)
//    protected TextView phoneNumberTextView;
//
//    @Bind(R.id.text_view_username)
//    protected TextView usernameTextView;

//    @Bind(R.id.recycler_view_shared_media)
//    protected RecyclerView recyclerView;

    private MediaAdapter adapter;
    private boolean isHideToolbarView = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
//        usernameTextView.setText(username);
//        phoneNumberTextView.setText(phoneNumber);
//        bioTextView.setText(bio);
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
//        String name = nameEditText.getText().toString();
//        String lastSeen = lastSeenEditText.getText().toString();
//        initUi(name, lastSeen);
//        ArrayList<Media> mediaArrayList = new ArrayList<>();
//        mediaArrayList.add(new Media("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRzDtIIn3HzDZsOTSP5BYIGBuexMaDHO8evBQx_sy_Hn36Mp5OWjQ"));
//        mediaArrayList.add(new Media("https://www.skymetweather.com//themes/skymet/images/satellite/insat/thumb-web.jpg?x=1524377804"));
//        mediaArrayList.add(new Media("https://www.zimbabweflora.co.zw/speciesdata/images/11/112960-2.jpg"));
//        mediaArrayList.add(new Media("https://www.expertafrica.com/images/area/868_l.jpg"));
//        mediaArrayList.add(new Media("https://www.malawi-music.com/images/albums/pangono.jpg"));
//        mediaArrayList.add(new Media("http://www.diveworldwide.com/images/products/shark_diving_species_whale_shark.jpg"));
//        mediaArrayList.add(new Media("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTHWsnPuWFJJglzJOCdqz4IB-LfkPlad79rE_A8NuhRVWpL76bC"));
//        mediaArrayList.add(new Media("https://image-cdn.neatoshop.com/styleimg/67183/none/kiwigreen/default/371936-19;1512965831i.jpg"));
//        mediaArrayList.add(new Media("https://dqgroc0ic5iei.cloudfront.net/images/GoestaReiland_DSC01125-CMSTemplate.2e16d0ba.fill-400x400_6Wso0qQ.jpg"));
//        adapter = new MediaAdapter(mediaArrayList, this);
//        recyclerView.setAdapter(adapter);
    }

    public void onMessageButtonClicked(View view) {

    }

    public void onCallButtonClicked(View view) {

    }

    public void showAllSharedMedia(View view){

    }

    @Override
    public void onClick(View view, int position) {

    }
}
