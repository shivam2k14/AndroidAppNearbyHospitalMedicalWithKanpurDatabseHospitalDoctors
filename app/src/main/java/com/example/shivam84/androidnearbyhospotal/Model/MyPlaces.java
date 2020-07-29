package com.example.shivam84.androidnearbyhospotal.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by shivam84 on 3/12/2018.
 */
public class MyPlaces {

    @SerializedName("results")
    private Results[] results;

    @SerializedName("html_attributions")
    private String[] html_attributions;

    @SerializedName("status")
    private String status;

    List<Results> nearbyPlaceList;

    public List<Results> getNearbyPlaceList() {
        return nearbyPlaceList;
    }

    public void setNearbyPlaceList(List<Results> nearbyPlaceList) {
        this.nearbyPlaceList = nearbyPlaceList;
    }

    public Results[] getResults ()
    {
        return results;
    }

    public void setResults (Results[] results)
    {
        this.results = results;
    }

    public String[] getHtml_attributions ()
    {
        return html_attributions;
    }

    public void setHtml_attributions (String[] html_attributions)
    {
        this.html_attributions = html_attributions;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [results = "+results+", html_attributions = "+html_attributions+", status = "+status+"]";
    }

}

