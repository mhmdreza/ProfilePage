package com.anton46.whatsapp_profile.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.anton46.whatsapp_profile.R;
import com.anton46.whatsapp_profile.listeners.MediaListener;

import butterknife.Bind;

public class MediaViewHolder extends RecyclerView.ViewHolder{
    @Bind(R.id.image_view_media_card) ImageView mediaImageView;

    public MediaViewHolder(View itemView, final MediaListener listener) {
        super(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(view, getAdapterPosition());
            }
        });
    }

    public void setMedia(String url){
//        Glide.with(itemView.getContext()).load(url).into(mediaImageView);
    }
}
