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

/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment extends BaseFragment {

    private TextView bioTextView;
    private TextView phoneNumberTextView;
    private TextView usernameTextView;


    public UserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        sharedMediaRecyclerView = view.findViewById(R.id.recycler_view_shared_media);
        bioTextView = view.findViewById(R.id.text_view_bio);
        phoneNumberTextView  = view.findViewById(R.id.text_view_phone_number);
        usernameTextView = view.findViewById(R.id.text_view_username);
        notificationOptionTextView = view.findViewById(R.id.text_view_notification_option);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initializeViews() {
        String username = "@username";
        String phoneNumber = "09123456789";
        String bio = "my bio my bio my bio my bio!!!";
        usernameTextView.setText(username);
        phoneNumberTextView.setText(phoneNumber);
        bioTextView.setText(bio);
    }

}
