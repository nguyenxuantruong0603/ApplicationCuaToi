package com.example.applicationcuatoi.view.login;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.applicationcuatoi.datamodel.TheMovie;
import com.example.applicationcuatoi.view.HomeActivity;

import java.util.List;

public class LoginViewModel extends ViewModel {

    private Context context;

    public LoginViewModel(Context context) {
        this.context = context;
    }

    // xử lý sự kiện khi click đăng nhập
    public void onClickLogin(String username, String password) {
        if (username.equals("Admin") && password.equals("Admin")) {
            Toast.makeText(context, "Xin Chào Admin !", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context, HomeActivity.class);
            context.startActivity(intent);
        } else if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(context, "Không được bỏ trống", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Tài khoản hoặc mật khẩu không đúng", Toast.LENGTH_SHORT).show();
        }
    }

    public void clickForgotPassword(){
        Toast.makeText(context, "ngu thì chết hỏi hỏi cái quần què !", Toast.LENGTH_SHORT).show();
    }

}
