package com.anton46.whatsapp_profile.views.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.anton46.whatsapp_profile.R;
import com.anton46.whatsapp_profile.views.media.MediaAdapter;
import com.anton46.whatsapp_profile.views.media.viewModel.MediaViewModel;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseFragment extends Fragment {
    protected RecyclerView sharedMediaRecyclerView;
    protected TextView notificationOptionTextView;

    public BaseFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        initializeSharedMedia();
        initializeViews();
        notificationOptionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String option = notificationOptionTextView.getText().toString();
                if (option.equals(getString(R.string.notification_status_on))) {
                    notificationOptionTextView.setText(R.string.notification_status_off);
                }
                else {
                    notificationOptionTextView.setText(R.string.notification_status_on);
                }
            }
        });
    }

    protected void initializeSharedMedia() {
        ArrayList<MediaViewModel> mediaArrayList = new ArrayList<>();
        MediaAdapter adapter = new MediaAdapter(mediaArrayList);
        sharedMediaRecyclerView.setNestedScrollingEnabled(false);
        sharedMediaRecyclerView.setAdapter(adapter);
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
    }

    protected abstract void initializeViews();

}
