package com.example.applicationcuatoi.view.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.applicationcuatoi.R;
import com.example.applicationcuatoi.databinding.ActivityLoginBinding;
import com.example.applicationcuatoi.datamodel.user.User;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        LoginViewModel loginViewModel = new LoginViewModel(this);

        binding.setUser(loginViewModel);

        // lắng nghe sự thay đổi dữ liệu của User
        loginViewModel.getUserMutableLiveData().observe(this, user -> {
            if (user != null) {
            } else {
                user = new User.UserBuilder()
                        .setEmail("admin")
                        .setpassword("123")
                        .createUser();
            }
        });


    }
}