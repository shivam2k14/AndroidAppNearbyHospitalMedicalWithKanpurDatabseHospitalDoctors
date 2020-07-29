package com.example.shivam84.androidnearbyhospotal.Remote;

import com.example.shivam84.androidnearbyhospotal.Model.MyPlaces;
import com.example.shivam84.androidnearbyhospotal.Model.PlaceDetails;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by shivam84 on 3/12/2018.
 */
public interface IGoogleApiService {

    @GET
    Call<MyPlaces> getNearByPlaces(@Url String url);

    @GET
    Call<PlaceDetails> getDetailsPlaces(@Url String url);
}
