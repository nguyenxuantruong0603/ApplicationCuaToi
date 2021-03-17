package com.example.applicationcuatoi.utils;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.applicationcuatoi.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class ActionBottomDialogFragment extends BottomSheetDialogFragment
        implements View.OnClickListener {

    public static final String TAG = "ActionBottomDialog";
    private ItemClickListener mListener;
    public static ActionBottomDialogFragment newInstance() {
        return new ActionBottomDialogFragment();
    }
    @Nullable @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.bottom_sheet, container, false);
    }
    @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        view.findViewById(R.id.textView).setOnClickListener(this);
//        view.findViewById(R.id.textView2).setOnClickListener(this);
//        view.findViewById(R.id.textView3).setOnClickListener(this);
//        view.findViewById(R.id.textView4).setOnClickListener(this);
    }

    @Override public void onClick(View view) {

    }

    public interface ItemClickListener {
        void onItemClick(String item);
    }
}
