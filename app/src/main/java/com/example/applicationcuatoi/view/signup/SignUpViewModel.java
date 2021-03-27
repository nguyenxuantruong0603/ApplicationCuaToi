package com.example.applicationcuatoi.view.signup;

import android.content.Context;
import android.widget.Toast;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.applicationcuatoi.datamodel.user.User;



public class SignUpViewModel extends ViewModel {

    private Context context;
    private MutableLiveData<User> userMutableLiveData;

    public MutableLiveData<String> email = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();
    public MutableLiveData<String> address = new MutableLiveData<>();
    public MutableLiveData<String> phonenumber = new MutableLiveData<>();

    public MutableLiveData<String> errorPassword = new MutableLiveData<>();
    public MutableLiveData<String> errorEmail = new MutableLiveData<>();


    public SignUpViewModel(Context context) {
        this.context = context;
    }

    public MutableLiveData<User> getUserMutableLiveData() {
        if (userMutableLiveData == null) {
            userMutableLiveData = new MutableLiveData<>();
        }
        return userMutableLiveData;
    }

    public void onClickSignUp() {
        User user = new User(email.getValue(), password.getValue());

        if (!user.isEmailValid() || !user.isPasswordValid()) {
            errorEmail.setValue("Enter a valid email address");
            errorPassword.setValue("Password Length should be greater than 6");
        } else {
            errorEmail.setValue(null);
            errorPassword.setValue(null);
            Toast.makeText(context, "Đăng ký thành công", Toast.LENGTH_SHORT).show();

        }

    }


}
