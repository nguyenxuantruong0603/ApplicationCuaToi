package com.example.applicationcuatoi.view.signup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import com.example.applicationcuatoi.R;
import com.example.applicationcuatoi.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivitySignUpBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up);

        SignUpViewModel signUpViewModel = new SignUpViewModel(this);

        binding.setSignUpViewModel(signUpViewModel);
        binding.setLifecycleOwner(this);

        signUpViewModel.getUserMutableLiveData().observe(this, user -> {

        });

        binding.toolbarSignUp.setNavigationIcon(R.drawable.ic_arrow_back);
        binding.toolbarSignUp.setNavigationOnClickListener(v -> finish());

    }
}