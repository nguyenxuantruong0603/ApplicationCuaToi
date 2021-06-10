package com.example.applicationcuatoi.view.ui.toprated;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.applicationcuatoi.client.RetrofitClient;
import com.example.applicationcuatoi.client.TopRatedApiService;
import com.example.applicationcuatoi.datamodel.movie.ResultTheMovie;
import com.example.applicationcuatoi.datamodel.movie.TheMovie;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopRatedViewModel extends ViewModel {

    private MutableLiveData<List<TheMovie>> listMutableLiveData;

    public MutableLiveData<List<TheMovie>> getListMutableLiveData() {
        if (listMutableLiveData == null) {
            listMutableLiveData = new MutableLiveData<>();
        }
        return listMutableLiveData;
    }

    public void getTopRatedApi() {
        TopRatedApiService apiService = RetrofitClient.getInstance().create(TopRatedApiService.class);
        Call<ResultTheMovie> call = apiService.getResult();
        call.enqueue(new Callback<ResultTheMovie>() {
            @Override
            public void onResponse(@NotNull Call<ResultTheMovie> call, @NotNull Response<ResultTheMovie> response) {
                if (response.isSuccessful()) {
                    listMutableLiveData.postValue(Objects.requireNonNull(response.body()).getTheMovies());
                    Log.e("DATA", "Size: " + response.body().getTheMovies().size());
                } else if (response.code() == 404) {
                    Log.e("404", "Sai đường dẫn");
                } else {
                    Log.e("CODE", response.code() + "");
                }
            }

            @Override
            public void onFailure(@NotNull Call<ResultTheMovie> call, @NotNull Throwable t) {
                Log.e("FAIL", t.getMessage());
            }
        });

    }
}
