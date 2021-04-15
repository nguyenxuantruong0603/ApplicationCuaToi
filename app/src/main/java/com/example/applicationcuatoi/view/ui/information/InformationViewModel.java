package com.example.applicationcuatoi.view.ui.information;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.applicationcuatoi.datamodel.user.User;

import java.util.ArrayList;
import java.util.List;

public class InformationViewModel extends ViewModel {

    private MutableLiveData<List<User>> userMutableLiveData;
    private List<User> userList = new ArrayList<>();

    public MutableLiveData<List<User>> getUserMutableLiveData() {
        if (userMutableLiveData == null) {
            userMutableLiveData = new MutableLiveData<>();
        }
        return userMutableLiveData;
    }

        }
