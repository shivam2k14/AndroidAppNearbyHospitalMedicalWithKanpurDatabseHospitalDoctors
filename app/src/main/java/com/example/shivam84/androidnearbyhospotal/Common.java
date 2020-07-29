package com.example.shivam84.androidnearbyhospotal;

import com.example.shivam84.androidnearbyhospotal.Model.MyPlaces;
import com.example.shivam84.androidnearbyhospotal.Model.Result;
import com.example.shivam84.androidnearbyhospotal.Model.Results;
import com.example.shivam84.androidnearbyhospotal.Remote.IGoogleApiService;
import com.example.shivam84.androidnearbyhospotal.Remote.RetrofitClint;

/**
 * Created by shivam84 on 3/12/2018.
 */
public class Common {
    public static Results currentResult;
    public static Result currentResult1;   //for places
    private static final String GOOGLE_API_URL="https://maps.googleapis.com/";


    public static IGoogleApiService getGoogleApiService(){
        return RetrofitClint.getClient(GOOGLE_API_URL).create(IGoogleApiService.class);
    }
}

