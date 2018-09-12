package com.anton46.whatsapp_profile.views;

import android.content.Context;
import android.support.annotation.MainThread;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.anton46.whatsapp_profile.Media;
import com.anton46.whatsapp_profile.R;
import com.anton46.whatsapp_profile.listeners.MediaListener;

import java.util.ArrayList;

public class MediaAdapter extends RecyclerView.Adapter<MediaViewHolder> {
    private ArrayList<Media> list;
    private MediaListener listener;

    public MediaAdapter(ArrayList<Media> list, MediaListener listener) {
        this.list = list;
        this.listener = listener;
    }

    @Override
    public MediaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.media_card, null);
        return new MediaViewHolder(view, listener);
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
