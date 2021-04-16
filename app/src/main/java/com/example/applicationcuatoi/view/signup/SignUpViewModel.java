package com.example.applicationcuatoi.view.signup;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.applicationcuatoi.datamodel.user.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpViewModel extends ViewModel {

    @SuppressLint("StaticFieldLeak")
    private final Context context;
    private MutableLiveData<User> userMutableLiveData;

    public MutableLiveData<String> email = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();
    public MutableLiveData<String> address = new MutableLiveData<>();
    public MutableLiveData<String> phonenumber = new MutableLiveData<>();

    public MutableLiveData<String> errorPassword = new MutableLiveData<>();
    public MutableLiveData<String> errorEmail = new MutableLiveData<>();

    public FirebaseDatabase firebaseDatabase;


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

        firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = firebaseDatabase.getReference("user");

        User user = new User(email.getValue(), password.getValue());

        if (user.getEmail().isEmpty() || user.getPassword().isEmpty()) {
            errorEmail.setValue("Email is not Empty ");
            errorPassword.setValue("Password is not Empty");
        } else if (user.getEmail().matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]") || user.getPassword().length() > 6) {
            errorPassword.setValue(null);
            email.setValue("");
            password.setValue("");
            myRef.push().setValue(user);
            Toast.makeText(context, "SignUp Success", Toast.LENGTH_SHORT).show();
        } else {
            errorEmail.setValue("Enter a valid email address");
            errorPassword.setValue("Password Length should be greater than 6");

        }

    }


}
