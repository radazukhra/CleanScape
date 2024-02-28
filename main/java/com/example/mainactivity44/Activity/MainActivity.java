package com.example.mainactivity44.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.mainactivity44.R;

public class MainActivity extends AppCompatActivity {
    RecyclerView not_cleaned_rview;
    ImageView new_post_button;
    ImageView favorites_button;
    ImageView my_profile_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        not_cleaned_rview = findViewById(R.id.not_cleaned_rview);
        new_post_button = findViewById(R.id.new_post_button);
        my_profile_button = findViewById(R.id.my_profile_button);
        favorites_button = findViewById(R.id.favorites_button);
        not_cleaned_rview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = PublicationViewActivity.newIntent(MainActivity.this);
                startActivity(intent);
                finish();
            }
        });
        new_post_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = NewPublicationActivity.newIntent(MainActivity.this);
                startActivity(intent);
                finish();
            }
        });
        my_profile_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = ProfileActivity.newIntent(MainActivity.this);
                startActivity(intent);
                finish();
            }
        });
        favorites_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = MyPublicationsActivity.newIntent(MainActivity.this);
                startActivity(intent);
                finish();
            }
        });

    }


    public static Intent newIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }
}