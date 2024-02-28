package com.example.mainactivity44.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mainactivity44.ViewModel.ProfileViewModel;
import com.example.mainactivity44.R;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Set;

public class ProfileActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProfileViewModel viewModel;
    private TextView logout_button;
    private TextView settings;
    private ImageView new_post_button;
    private ImageView home_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        viewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
        initViews();
        observeViewModel();
        setupClickListeners();
    }

    private void observeViewModel() {
        viewModel.getUser().observe(this, new Observer<FirebaseUser>() {
            @Override
            public void onChanged(FirebaseUser firebaseUser) {
                if (firebaseUser == null) {
                    Intent intent = LoginActivity.newIntent(ProfileActivity.this);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void initViews() {
        logout_button = findViewById(R.id.logout_button);
        settings = findViewById(R.id.settings);
        new_post_button = findViewById(R.id.new_post_button);
        home_button = findViewById(R.id.home_button);
    }

    private void setupClickListeners() {
        logout_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = LoginActivity.newIntent(ProfileActivity.this);
                startActivity(intent);
                viewModel.logout();

            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = SettingsActivity.newIntent(ProfileActivity.this);
                startActivity(intent);
                finish();
            }
        });
        new_post_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = NewPublicationActivity.newIntent(ProfileActivity.this);
                startActivity(intent);
                finish();
            }
        });
        home_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = MainActivity.newIntent(ProfileActivity.this);
                startActivity(intent);
                finish();
            }
        });

    }

    public static Intent newIntent(Context context) {
        return new Intent(context, ProfileActivity.class);
    }

}