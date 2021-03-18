package com.example.applicationcuatoi.view.ui.popularmovie;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.applicationcuatoi.R;
import com.example.applicationcuatoi.adapter.FavoriteMovieAdapter;


public class PopularMovieFragment extends Fragment {

    private PopularMovieViewModel popularMovieViewModel;
    private FavoriteMovieAdapter favoriteMovieAdapter;

    @SuppressLint("FragmentLiveDataObserve")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_favorite_movie, container, false);

        RecyclerView rcFavoriteMovie = view.findViewById(R.id.rcFavoriteMovie);

        popularMovieViewModel = new ViewModelProvider(this).get(PopularMovieViewModel.class);

        popularMovieViewModel.getListMutableLiveData().observe(this, theMovies -> {

            favoriteMovieAdapter = new FavoriteMovieAdapter(theMovies,getContext());

            rcFavoriteMovie.setAdapter(favoriteMovieAdapter);

        });

        popularMovieViewModel.getTheMovieApi();

        return view;
    }
}