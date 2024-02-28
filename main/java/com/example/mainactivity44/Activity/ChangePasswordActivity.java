package com.example.mainactivity44.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mainactivity44.R;
import com.example.mainactivity44.ViewModel.ChangePasswordViewModel;

public class ChangePasswordActivity extends AppCompatActivity {
    private Button registration;
    private TextView backButton;
    private EditText email;

    private ChangePasswordViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        initViews();
        viewModel = new ViewModelProvider(this).get(ChangePasswordViewModel.class);
        observeViewModel();
        setupClickListeners();
    }
    private void setupClickListeners() {

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = SettingsActivity.newIntent(ChangePasswordActivity.this);
                startActivity(intent);
                finish();
            }
        });
        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailUser = email.getText().toString().trim();
                viewModel.resetPassword(emailUser);
            }
        });
    }


    private void observeViewModel() {
        viewModel.getError().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String errorMessage) {
                if (errorMessage != null) {
                    Toast.makeText(ChangePasswordActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
                }
            }
        });

        viewModel.isSuccess().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean success) {
                if (success) {
                    Toast.makeText(ChangePasswordActivity.this, "Письмо было успешно отправлено", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
    private void initViews() {
        registration = findViewById(R.id.registration);
        backButton = findViewById(R.id.backButton);
        email = findViewById(R.id.email);

    }
    public static Intent newIntent(Context context) {
        return new Intent(context,ChangePasswordActivity.class);
    }



}