package com.example.shivam84.androidnearbyhospotal.Remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by shivam84 on 3/12/2018.
 */
public class RetrofitClint {
    private static Retrofit retrofit=null;
    public static Retrofit getClient(String baseUrl){
        if(retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
