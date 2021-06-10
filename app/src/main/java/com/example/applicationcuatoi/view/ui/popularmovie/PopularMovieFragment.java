package com.example.applicationcuatoi.view.ui.popularmovie;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
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
import com.example.applicationcuatoi.datamodel.movie.TheMovie;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class PopularMovieFragment extends Fragment {

    private PopularAdapter popularAdapter;

    @SuppressLint({"FragmentLiveDataObserve", "CheckResult"})
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        FragmentFavoriteMovieBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_favorite_movie, container, false);

        View view = binding.getRoot();

        PopularMovieViewModel popularMovieViewModel = new ViewModelProvider(this).get(PopularMovieViewModel.class);

        popularMovieViewModel.getListMutableLiveData().observe(this, theMovies -> {

//                Observable.just(theMovies)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeWith(new Observer<List<TheMovie>>() {
//                    @Override
//                    public void onSubscribe(@io.reactivex.annotations.NonNull Disposable d) {
//                        Log.e("RxAndroid onSubscribe", "onSubscribe");
//                    }
//
//                    @Override
//                    public void onNext(@io.reactivex.annotations.NonNull List<TheMovie> theMovies) {
//                        Log.e("RxAndroid onNext", theMovies.size() + "");
//                    }
//
//                    @Override
//                    public void onError(@io.reactivex.annotations.NonNull Throwable e) {
//                        Log.e("RxAndroid onError", e.getMessage() + "");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        popularAdapter = new PopularAdapter(theMovies, getContext());
//                        binding.rcFavoriteMovie.setAdapter(popularAdapter);
//                        Log.e("RxAndroid onComplete", "onComplete");
//                    }
//                })
            popularAdapter = new PopularAdapter(theMovies, getContext());
            binding.rcFavoriteMovie.setAdapter(popularAdapter);
        });

        popularMovieViewModel.getTheMovieApi();

        return view;
    }
}