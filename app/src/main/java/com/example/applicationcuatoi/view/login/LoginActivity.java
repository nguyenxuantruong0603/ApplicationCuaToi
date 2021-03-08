package com.example.applicationcuatoi.view.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import com.example.applicationcuatoi.R;
import com.example.applicationcuatoi.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        loginViewModel = new LoginViewModel(this);

        binding.btnLogin.setOnClickListener(v -> {
            String username = binding.edtEmail.getText().toString();
            String password = binding.edtPassword.getText().toString();
            loginViewModel.onClickLogin(username, password);
        });

        binding.tvForgotPassword.setOnClickListener(v -> loginViewModel.clickForgotPassword());

        binding.tvSignUp.setOnClickListener(v -> loginViewModel.onClickSignUp());
    }
}