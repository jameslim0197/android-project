package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    public static final String EMAIL = "com.example.firstproject.EMAIL";
    public static final String PASSWORD = "com.example.firstproject.PASSWORD";
    @BindView(R.id.etEmail) EditText emailEditView;
    @BindView(R.id.etPassword) EditText passwordEditView;
    @BindView(R.id.btLogin) Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    public void loginMember(View view) {
        Intent intent = new Intent(this, DisplayLoginResponse.class);
        String email = emailEditView.getText().toString();
        String password = passwordEditView.getText().toString();
        intent.putExtra(EMAIL, email);
        intent.putExtra(PASSWORD, password);
        startActivity(intent);
    }

    public void registerMember(View view) {
        Intent intent = new Intent(this, RegisterMember.class);
        startActivity(intent);
    }
}
