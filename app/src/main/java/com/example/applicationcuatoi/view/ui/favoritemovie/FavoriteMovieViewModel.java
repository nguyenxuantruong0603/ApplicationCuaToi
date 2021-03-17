package com.example.applicationcuatoi.view.ui.favoritemovie;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.applicationcuatoi.apicalling.MovieApiService;
import com.example.applicationcuatoi.apicalling.RetrofitCallMovie;
import com.example.applicationcuatoi.datamodel.movie.ResultTheMovie;
import com.example.applicationcuatoi.datamodel.movie.TheMovie;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FavoriteMovieViewModel extends ViewModel {

    private MutableLiveData<List<TheMovie>> listMutableLiveData;


    public MutableLiveData<List<TheMovie>> getListMutableLiveData() {

        if (listMutableLiveData == null) {
            listMutableLiveData = new MutableLiveData<List<TheMovie>>();
            getTheMovieApi();
        }

        return listMutableLiveData;
    }

    public void getTheMovieApi() {
        MovieApiService callMovie = RetrofitCallMovie.getInstance().create(MovieApiService.class);
        Call<ResultTheMovie> call = callMovie.getResult();
        call.enqueue(new Callback<ResultTheMovie>() {
            @Override
            public void onResponse(Call<ResultTheMovie> call, Response<ResultTheMovie> response) {
                listMutableLiveData.postValue(response.body().getTheMovies());
                Log.e("TheMovie", response.body().getTheMovies().toString());
                Log.e("SIZE: ", response.body().getTheMovies().size() + "");
            }

            @Override
            public void onFailure(Call<ResultTheMovie> call, Throwable t) {
                Log.e("TheMovie", "Fail Get Api: " + t.getMessage());

            }
        });


    }

}