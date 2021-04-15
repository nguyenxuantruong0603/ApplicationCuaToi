package com.example.applicationcuatoi.view.ui.popularmovie;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.applicationcuatoi.R;
import com.example.applicationcuatoi.adapter.PopularAdapter;
import com.example.applicationcuatoi.databinding.FragmentFavoriteMovieBinding;


public class PopularMovieFragment extends Fragment {

    private PopularMovieViewModel popularMovieViewModel;
    private PopularAdapter popularAdapter;

    @SuppressLint("FragmentLiveDataObserve")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        FragmentFavoriteMovieBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_favorite_movie, container, false);

        View view = binding.getRoot();

        popularMovieViewModel = new ViewModelProvider(this).get(PopularMovieViewModel.class);

        popularMovieViewModel.getListMutableLiveData().observe(this, theMovies -> {

            popularAdapter = new PopularAdapter(theMovies, getContext());

            binding.rcFavoriteMovie.setAdapter(popularAdapter);

        });

        popularMovieViewModel.getTheMovieApi();

        return view;
    }
}