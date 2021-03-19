package com.example.applicationcuatoi.view.ui.toprated;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.applicationcuatoi.R;
import com.example.applicationcuatoi.adapter.PopularAdapter;
import com.example.applicationcuatoi.adapter.TopRatedAdapter;


public class TopRatedFragment extends Fragment {

    private TopRatedViewModel topRatedViewModel;
    private TopRatedAdapter topRatedAdapter;

    @SuppressLint("FragmentLiveDataObserve")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_top_rated, container, false);
        RecyclerView rcTopRated = view.findViewById(R.id.rcTopRated);


        topRatedViewModel = new ViewModelProvider(this).get(TopRatedViewModel.class);

        topRatedViewModel.getTopRatedApi();

        topRatedViewModel.getListMutableLiveData().observe(this, theMovies -> {
            topRatedAdapter = new TopRatedAdapter(theMovies, getContext());
            rcTopRated.setAdapter(topRatedAdapter);
        });
        return view;


    }


}
