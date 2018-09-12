package com.anton46.whatsapp_profile.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.anton46.whatsapp_profile.R;
import com.anton46.whatsapp_profile.listeners.MediaListener;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import butterknife.Bind;

public class MediaViewHolder extends RecyclerView.ViewHolder{
    private ImageView mediaImageView;

    public MediaViewHolder(View itemView, final MediaListener listener) {
        super(itemView);
        mediaImageView = itemView.findViewById(R.id.image_view_media_card);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(view, getAdapterPosition());
            }
        });
    }

    public void setMedia(String url){
        Glide.with(itemView.getContext())
                .load(url)
                .apply(new RequestOptions().transform(new RoundedCorners(10)))
                .into(mediaImageView);
    }
}
