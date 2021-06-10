package com.example.applicationcuatoi.view.ui.toprated;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.applicationcuatoi.R;
import com.example.applicationcuatoi.adapter.TopRatedAdapter;
import com.example.applicationcuatoi.databinding.FragmentTopRatedBinding;
import com.example.applicationcuatoi.datamodel.movie.TheMovie;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class TopRatedFragment extends Fragment {

    private TopRatedAdapter topRatedAdapter;

    @SuppressLint({"FragmentLiveDataObserve", "CheckResult"})
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentTopRatedBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_top_rated, container, false);
        View view = binding.getRoot();

        TopRatedViewModel topRatedViewModel = new ViewModelProvider(this).get(TopRatedViewModel.class);

        topRatedViewModel.getTopRatedApi();

        topRatedViewModel.getListMutableLiveData().observe(this, theMovies -> {
//                Observable.just(theMovies)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeWith(new Observer<List<TheMovie>>() {
//                    @Override
//                    public void onSubscribe(@io.reactivex.annotations.NonNull Disposable d) {
//                        Log.e("RxAndroid onSubscribe", "Subscribed");
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
//                        topRatedAdapter = new TopRatedAdapter(theMovies, getContext());
//                        binding.rcTopRated.setAdapter(topRatedAdapter);
//                        Log.e("RxAndroid onComplete", "onComplete");
//
//                    }
//                })

            topRatedAdapter = new TopRatedAdapter(theMovies, getContext());
            binding.rcTopRated.setAdapter(topRatedAdapter);
        });
        return view;


    }


}
