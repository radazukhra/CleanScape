package com.example.mainactivity44.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.mainactivity44.R;

public class SettingsActivity extends AppCompatActivity {

    private TextView changeName;
    private TextView changePassword;
    private TextView changeAvatar;
    private TextView backButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        initViews();
        setupClickListeners();
    }

    private void setupClickListeners() {

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = ProfileActivity.newIntent(SettingsActivity.this);
                startActivity(intent);
                finish();
            }
        });
        changeName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = ChangeNickNameActivity.newIntent(SettingsActivity.this);
                startActivity(intent);
                finish();
            }
        });
        changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = ChangePasswordActivity.newIntent(SettingsActivity.this);
                startActivity(intent);
                finish();
            }
        });
    }

    private void initViews() {
        changeName = findViewById(R.id.changeName);
        changePassword = findViewById(R.id.changePassword);
        changeAvatar = findViewById(R.id.changeAvatar);
        backButton = findViewById(R.id.backButton);

    }

    public static Intent newIntent(Context context) {
        return new Intent(context,SettingsActivity.class);
    }

}