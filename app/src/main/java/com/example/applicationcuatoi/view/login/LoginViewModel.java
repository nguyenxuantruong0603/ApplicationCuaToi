package com.example.applicationcuatoi.view.login;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.applicationcuatoi.R;
import com.example.applicationcuatoi.datamodel.user.User;
import com.example.applicationcuatoi.view.home.HomeActivity;
import com.example.applicationcuatoi.view.signup.SignUpActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LoginViewModel extends ViewModel {

    @SuppressLint("StaticFieldLeak")
    private final Context context;
    private final MutableLiveData<List<User>> userMutableLiveData = new MutableLiveData<>();
    private final List<User> userList = new ArrayList<>();
    public MutableLiveData<String> username = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();

    public LoginViewModel(Context context) {
        this.context = context;
    }

    public MutableLiveData<List<User>> getUserMutableLiveData() {
        return userMutableLiveData;
    }

    public void getListUser() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("user");
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    User user = snapshot.getValue(User.class);

                    if (user != null) {
                        String email = user.getEmail();
                        String password = user.getPassword();
                        String address = user.getAddress();
                        String phone_number = user.getPhoneNumber();
                        String sex = user.getSex();
                        int age = user.getAge();

                        userList.add(new User.UserBuilder()
                                .setEmail(email)
                                .setpassword(password)
                                .setAdress(address)
                                .setPhoneNumber(phone_number)
                                .setSex(sex)
                                .setAge(age)
                                .createUser());
                    }

                }

                userMutableLiveData.setValue(userList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @SuppressLint("InflateParams")
    public void onClickLogin() {

        String email = username.getValue();
        String pass = password.getValue();

        AlertDialog builder = new AlertDialog.Builder(context).create();
        builder.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        builder.setView(LayoutInflater.from(context).inflate(R.layout.dialog_await_api_feedback, null));
        builder.show();

        for (int i = 0; i < userList.size(); i++) {
            if (Objects.requireNonNull(email).equals(Objects.requireNonNull(userMutableLiveData.getValue()).get(i).getEmail()) && Objects.requireNonNull(pass).equals(userMutableLiveData.getValue().get(i).getPassword())) {
                builder.dismiss();
                Toast.makeText(context, "Hello " + userMutableLiveData.getValue().get(i).getEmail() + "!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, HomeActivity.class);
                context.startActivity(intent);
                break;
            } else if (email.equals("") || Objects.requireNonNull(pass).equals("")) {
                builder.dismiss();
                Toast.makeText(context, "Email or Password is not Empty", Toast.LENGTH_SHORT).show();
                break;
            } else {
                if (i == userList.size() - 1) {
                    builder.dismiss();
                    Toast.makeText(context, "Email or Password is incorrect. Please check again", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    public void clickForgotPassword() {
        Toast.makeText(context, "Forgot password !", Toast.LENGTH_SHORT).show();
    }

    public void onClickSignUp() {
        Intent intent = new Intent(context, SignUpActivity.class);
        context.startActivity(intent);
    }

}
