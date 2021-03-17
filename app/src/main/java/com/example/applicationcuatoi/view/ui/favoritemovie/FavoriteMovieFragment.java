package com.example.applicationcuatoi.view.ui.favoritemovie;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.applicationcuatoi.R;
import com.example.applicationcuatoi.adapter.FavoriteMovieAdapter;
import com.example.applicationcuatoi.datamodel.movie.TheMovie;

import java.util.List;


public class FavoriteMovieFragment extends Fragment {

    private FavoriteMovieViewModel favoriteMovieViewModel;
    private FavoriteMovieAdapter favoriteMovieAdapter;

    @SuppressLint("FragmentLiveDataObserve")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_favorite_movie, container, false);

        RecyclerView rcFavoriteMovie = view.findViewById(R.id.rcFavoriteMovie);

        favoriteMovieViewModel = new ViewModelProvider(this).get(FavoriteMovieViewModel.class);

        favoriteMovieViewModel.getListMutableLiveData().observe(this, theMovies -> {

            favoriteMovieAdapter = new FavoriteMovieAdapter(theMovies,getContext());

            rcFavoriteMovie.setAdapter(favoriteMovieAdapter);

        });

        favoriteMovieViewModel.getTheMovieApi();

        return view;
    }
}