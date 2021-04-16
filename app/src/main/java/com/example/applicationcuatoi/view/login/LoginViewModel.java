package com.example.applicationcuatoi.view.login;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.applicationcuatoi.datamodel.user.User;
import com.example.applicationcuatoi.view.home.HomeActivity;
import com.example.applicationcuatoi.view.signup.SignUpActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class LoginViewModel extends ViewModel {

    @SuppressLint("StaticFieldLeak")
    private final Context context;
    private final MutableLiveData<List<User>> userMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<String> username = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();
    private List<User> userList = new ArrayList<>();

    public MutableLiveData<List<User>> getUserMutableLiveData() {
        return userMutableLiveData;
    }

    public LoginViewModel(Context context) {
        this.context = context;
    }

    public void getListUser() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("user");
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    User user = snapshot.getValue(User.class);

                    String email = user.getEmail();
                    String password = user.getPassword();
                    String address = user.getAddress();
                    int phone_number = user.getPhoneNumber();
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

                userMutableLiveData.setValue(userList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void onClickLogin() {

        String email = username.getValue();
        String pass = password.getValue();


        for (int i = 0; i < userList.size(); i++) {
            if (email.equals(userMutableLiveData.getValue().get(i).getEmail()) && pass.equals(userMutableLiveData.getValue().get(i).getPassword())) {
                Toast.makeText(context, "Xin Chào " + userMutableLiveData.getValue().get(i).getEmail() + "!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, HomeActivity.class);
                context.startActivity(intent);
                break;
            } else if (email.equals("") || pass.equals("")) {
                Toast.makeText(context, "Email or Password is not Empty", Toast.LENGTH_SHORT).show();
                break;
            } else {
                if (i == userList.size() - 1) {
                    Toast.makeText(context, "Email or Password is incorrect. Please check again", Toast.LENGTH_SHORT).show();
                }
            }
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
