package com.example.applicationcuatoi.apicalling;

import com.example.applicationcuatoi.datamodel.movie.ResultTheMovie;
import com.example.applicationcuatoi.datamodel.movie.TheMovie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieApiService {
    @GET("/3/movie/popular?api_key=8601e59580df086ab5ee641cead2d9b5")
    Call<ResultTheMovie> getResult();


}
