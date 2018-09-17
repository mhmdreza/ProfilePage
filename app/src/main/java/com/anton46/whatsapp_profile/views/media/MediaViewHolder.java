package com.anton46.whatsapp_profile.views.media;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.anton46.whatsapp_profile.MainActivity;
import com.anton46.whatsapp_profile.MediaActivity;
import com.anton46.whatsapp_profile.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

public class MediaViewHolder extends RecyclerView.ViewHolder{
    private ImageView mediaImageView;
    private String url = null;

    public MediaViewHolder(final View itemView) {
        super(itemView);
        mediaImageView = itemView.findViewById(R.id.image_view_media_card);
        mediaImageView.setBackground(itemView.getResources().getDrawable(R.drawable.media_card_background));
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(itemView.getContext(), MediaActivity.class);
                intent.putExtra("URL", url);
                itemView.getContext().startActivity(intent);
            }
        });
    }

    public void setMedia(String url){
        this.url = url;
        Glide.with(itemView.getContext())
                .load(url)
                .apply(new RequestOptions().transform(new RoundedCorners(10)))
                .into(mediaImageView);
    }
}