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
import com.example.mainactivity44.ViewModel.SigninViewModel;
import com.google.firebase.auth.FirebaseUser;

public class SigninActivity extends AppCompatActivity {

    private EditText username;
    private EditText nickname;
    private EditText emailSigninText;
    private EditText passwordSigninText;
    private EditText ageSigninText;
    private EditText phoneNumber;
    private Button registration;
    private TextView backButton;

    private SigninViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        initViews();
        viewModel = new ViewModelProvider(this).get(SigninViewModel.class);
        SetupClickListener();
        observeViewModel();


    }

    private void SetupClickListener() {
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = LoginActivity.newIntent(SigninActivity.this);
                startActivity(intent);
                finish();

            }
        });
        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = getTrimmedValue(username);
                String nickName = getTrimmedValue(nickname);
                String email = getTrimmedValue(emailSigninText);
                String password = getTrimmedValue(passwordSigninText);
                int ageUser = Integer.parseInt(getTrimmedValue(ageSigninText));
                String number = getTrimmedValue(phoneNumber);
                viewModel.signUp(userName, nickName, email, password, ageUser,number);
            }
        });

    }
    private void observeViewModel() {
        viewModel.getError().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String errorMessage) {
                if (errorMessage != null) {
                    Toast.makeText(SigninActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
                }
            }
        });
        viewModel.getUser().observe(this, new Observer<FirebaseUser>() {
            @Override
            public void onChanged(FirebaseUser firebaseUser) {
                if (firebaseUser != null ) {
                    Intent intent = ProfileActivity.newIntent(SigninActivity.this);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void initViews() {
        username = findViewById(R.id.username);
        nickname = findViewById(R.id.nickname);
        emailSigninText = findViewById(R.id.emailSigninText);
        passwordSigninText = findViewById(R.id.passwordSigninText);
        ageSigninText = findViewById(R.id.ageSigninText);
        phoneNumber = findViewById(R.id.phoneNumber);
        registration = findViewById(R.id.registration);
        backButton = findViewById(R.id.backButton);
    }

    private String getTrimmedValue(EditText editText){
        return editText.getText().toString().trim();
    }

    public static Intent newIntent(Context context) {
        return new Intent(context,SigninActivity.class);
    }

}