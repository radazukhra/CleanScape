package com.example.mainactivity44.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.mainactivity44.R;

public class MyPublicationsActivity extends AppCompatActivity {
    private ImageView favorites_button;
    ImageView new_post_button;
    ImageView my_profile_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_publications);
        favorites_button = findViewById(R.id.favorites_button);
        new_post_button = findViewById(R.id.new_post_button);
        my_profile_button = findViewById(R.id.my_profile_button);

    }

    public static Intent newIntent(Context context) {
        return new Intent(context, MyPublicationsActivity.class);
    }
}