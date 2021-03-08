package com.example.applicationcuatoi.view.signup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Toast;

import com.example.applicationcuatoi.R;
import com.example.applicationcuatoi.databinding.ActivitySignUpBinding;
import com.example.applicationcuatoi.datamodel.user.User;

public class SignUpActivity extends AppCompatActivity {

    private SignUpViewModel signUpViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivitySignUpBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up);

        signUpViewModel = new SignUpViewModel(this);

        binding.setSignUpViewModel(signUpViewModel);
        binding.setLifecycleOwner(this);

        signUpViewModel.getUserMutableLiveData().observe(this, user -> {

        });

    }
}