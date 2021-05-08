package com.example.applicationcuatoi.view.ui.information;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.applicationcuatoi.datamodel.user.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class InformationViewModel extends ViewModel {

    private final List<User> userList = new ArrayList<>();
    private MutableLiveData<List<User>> userMutableLiveData;

    public MutableLiveData<List<User>> getUserMutableLiveData() {
        if (userMutableLiveData == null) {
            userMutableLiveData = new MutableLiveData<>();
        }
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

}
