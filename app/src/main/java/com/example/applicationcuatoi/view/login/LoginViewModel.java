package com.example.applicationcuatoi.view.login;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.applicationcuatoi.datamodel.user.User;
import com.example.applicationcuatoi.view.home.HomeActivity;
import com.example.applicationcuatoi.view.signup.SignUpActivity;


public class LoginViewModel extends ViewModel {

    private Context context;
    private MutableLiveData<User> userMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<String> username = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();

    public MutableLiveData<User> getUserMutableLiveData() {
        return userMutableLiveData;
    }

    public LoginViewModel(Context context) {
        this.context = context;
    }

    public void onClickLogin() {

        User user = new User(username.getValue(), password.getValue());

        if (user.getEmail().equals("admin") && user.getPassword().equals("123")) {
            Toast.makeText(context, "Xin Chào Admin !", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context, HomeActivity.class);
            context.startActivity(intent);
        } else if (user.getEmail().equals("") || user.getPassword().equals("")) {
            Toast.makeText(context, "Không được bỏ trống", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Tài khoản hoặc mật khẩu không đúng", Toast.LENGTH_SHORT).show();
        }
    }

    public void clickForgotPassword() {
        Toast.makeText(context, "ngu thì chết bấm bấm caiconcac !", Toast.LENGTH_SHORT).show();
    }

    public void onClickSignUp() {
        Intent intent = new Intent(context, SignUpActivity.class);
        context.startActivity(intent);
    }


}
