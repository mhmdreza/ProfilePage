package com.anton46.whatsapp_profile.views.media;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anton46.whatsapp_profile.Media;
import com.anton46.whatsapp_profile.R;

import java.util.ArrayList;

public class MediaAdapter extends RecyclerView.Adapter<MediaViewHolder> {
    private ArrayList<Media> list;

    public MediaAdapter(ArrayList<Media> list) {
        this.list = list;
    }

    @Override
    public MediaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.media_card, null);
        return new MediaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MediaViewHolder holder, int position) {
        Media media = list.get(position);
        holder.setMedia(media.getUrl());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
