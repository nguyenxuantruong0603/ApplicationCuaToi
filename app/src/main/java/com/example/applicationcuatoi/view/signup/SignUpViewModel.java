package com.example.applicationcuatoi.view.signup;

import android.content.Context;
import android.widget.Toast;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.lifecycle.ViewModel;

import com.example.applicationcuatoi.BR;

public class SignUpViewModel extends BaseObservable {
    private String email;
    private String password;
    private String address;
    private int age;
    private int phonenumber;
    private String sex;
    private Context context;

    public SignUpViewModel(Context context) {
        this.context = context;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);

    }

    public void setAddress(String address) {
        this.address = address;
        notifyPropertyChanged(BR.address);

    }

    public void setAge(int age) {
        this.age = age;
        notifyPropertyChanged(BR.age);

    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
        notifyPropertyChanged(BR.phonenumber);

    }

    public void setSex(String sex) {
        this.sex = sex;
        notifyPropertyChanged(BR.sex);

    }

    @Bindable
    public String getEmail() {
        return email;
    }
    @Bindable
    public String getPassword() {
        return password;
    }
    @Bindable
    public String getAddress() {
        return address;
    }
    @Bindable
    public int getAge() {
        return age;
    }
    @Bindable
    public int getPhonenumber() {
        return phonenumber;
    }
    @Bindable
    public String getSex() {
        return sex;
    }



    public void onClickSignUp() {
        Toast.makeText(context, "Chán", Toast.LENGTH_SHORT).show();
    }

}
