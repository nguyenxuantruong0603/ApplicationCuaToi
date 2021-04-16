package com.example.applicationcuatoi.view.ui.information;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.applicationcuatoi.R;
import com.example.applicationcuatoi.adapter.InformationAdapter;
import com.example.applicationcuatoi.datamodel.user.User;

import java.util.List;

public class InformationFragment extends Fragment {

    private InformationAdapter informationAdapter;

    @SuppressLint("FragmentLiveDataObserve")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_information, container, false);
        RecyclerView rcInformation = root.findViewById(R.id.rcInformation);

        InformationViewModel informationViewModel = new ViewModelProvider(this).get(InformationViewModel.class);

        informationViewModel.getListUser();

        informationViewModel.getUserMutableLiveData().observe(this, users -> {

            informationAdapter = new InformationAdapter(users, getContext());
            rcInformation.setAdapter(informationAdapter);

        });


        return root;
    }
}