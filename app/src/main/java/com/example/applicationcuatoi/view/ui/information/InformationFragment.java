package com.example.applicationcuatoi.view.ui.information;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.applicationcuatoi.R;


public class InformationFragment extends Fragment {

    private InformationViewModel informationViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        informationViewModel =
                new ViewModelProvider(this).get(InformationViewModel.class);
        View root = inflater.inflate(R.layout.fragment_information, container, false);
        final TextView textView = root.findViewById(R.id.text_notifications);
        informationViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}