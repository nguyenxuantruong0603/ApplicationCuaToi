package com.example.applicationcuatoi.view.ui.popularmovie;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.applicationcuatoi.client.PopularApiService;
import com.example.applicationcuatoi.client.RetrofitClient;
import com.example.applicationcuatoi.datamodel.movie.ResultTheMovie;
import com.example.applicationcuatoi.datamodel.movie.TheMovie;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PopularMovieViewModel extends ViewModel {

    private MutableLiveData<List<TheMovie>> listMutableLiveData;


    public MutableLiveData<List<TheMovie>> getListMutableLiveData() {

        if (listMutableLiveData == null) {
            listMutableLiveData = new MutableLiveData<>();
            getTheMovieApi();
        }

        return listMutableLiveData;
    }

    public void getTheMovieApi() {
        PopularApiService callMovie = RetrofitClient.getInstance().create(PopularApiService.class);
        Call<ResultTheMovie> call = callMovie.getResult();
        call.enqueue(new Callback<ResultTheMovie>() {
            @Override
            public void onResponse(@NotNull Call<ResultTheMovie> call, @NotNull Response<ResultTheMovie> response) {
                if (response.isSuccessful()) {
                    listMutableLiveData.postValue(Objects.requireNonNull(response.body()).getTheMovies());
                    Log.e("TheMovie", response.body().getTheMovies().toString());
                    Log.e("SIZE: ", response.body().getTheMovies().size() + "");
                } else if (response.code() == 404) {
                    Log.e("404", "Sai đường dẫn");
                } else {
                    Log.e("CODE", response.code() + "");
                }
            }

            @Override
            public void onFailure(@NotNull Call<ResultTheMovie> call, @NotNull Throwable t) {
                Log.e("TheMovie", "Fail Get Api: " + t.getMessage());

            }
        });

    }

}