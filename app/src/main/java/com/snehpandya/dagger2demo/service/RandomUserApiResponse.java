package com.snehpandya.dagger2demo.service;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.snehpandya.dagger2demo.model.Result;

import java.util.List;

/**
 * Created by sneh.pandya on 16/11/17.
 */

public class RandomUserApiResponse {

    @SerializedName("results")
    @Expose
    private List<Result> results = null;

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}
