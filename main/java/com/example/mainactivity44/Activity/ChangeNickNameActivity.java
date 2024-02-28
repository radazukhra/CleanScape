package com.example.mainactivity44.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mainactivity44.R;

import java.util.Set;

public class ChangeNickNameActivity extends AppCompatActivity {
    private EditText nickname_new;
    private EditText password;
    private Button registration;
    private TextView backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_nick_name);
        initViews();
        setupClickListeners();
    }
    private void setupClickListeners() {

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = SettingsActivity.newIntent(ChangeNickNameActivity.this);
                startActivity(intent);
                finish();
            }
        });
        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = SettingsActivity.newIntent(ChangeNickNameActivity.this);
                startActivity(intent);
                finish();
            }
        });
    }
    private void initViews() {
        nickname_new = findViewById(R.id.nickname_new);
        password = findViewById(R.id.password);
        registration = findViewById(R.id.registration);
        backButton = findViewById(R.id.backButton);

    }

    public static Intent newIntent(Context context) {
        return new Intent(context,ChangeNickNameActivity.class);
    }
}