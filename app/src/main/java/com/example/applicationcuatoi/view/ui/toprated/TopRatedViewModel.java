package com.example.applicationcuatoi.view.ui.toprated;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.applicationcuatoi.apicalling.RetrofitCallMovie;
import com.example.applicationcuatoi.apicalling.TopRatedApiService;
import com.example.applicationcuatoi.datamodel.movie.ResultTheMovie;
import com.example.applicationcuatoi.datamodel.movie.TheMovie;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopRatedViewModel extends ViewModel {

    private MutableLiveData<List<TheMovie>> listMutableLiveData;

    public MutableLiveData<List<TheMovie>> getListMutableLiveData() {
        if (listMutableLiveData == null) {
            listMutableLiveData = new MutableLiveData<List<TheMovie>>();
        }
        return listMutableLiveData;
    }

    public void getTopRatedApi() {
        TopRatedApiService apiService = RetrofitCallMovie.getInstance().create(TopRatedApiService.class);
        Call<ResultTheMovie> call = apiService.getResult();
        call.enqueue(new Callback<ResultTheMovie>() {
            @Override
            public void onResponse(Call<ResultTheMovie> call, Response<ResultTheMovie> response) {
                listMutableLiveData.postValue(response.body().getTheMovies());
                Log.e("DATA", "Size: " + response.body().getTheMovies().size());
            }

            @Override
            public void onFailure(Call<ResultTheMovie> call, Throwable t) {
                Log.e("FAIL", t.getMessage());
            }
        });

    }
}
