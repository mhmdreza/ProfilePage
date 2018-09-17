package com.anton46.whatsapp_profile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MediaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);
        String url = getIntent().getStringExtra("URL");
        ImageView imageView = (ImageView) findViewById(R.id.image_view_media);
        Glide.with(this).load(url).into(imageView);
    }
}
