package com.snehpandya.dagger2demo.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by sneh.pandya on 16/11/17.
 */

    //TODO: 03. Setup Retrofit & model classes

public interface RandomUserService {
    @GET("api")
    Call<RandomUserApiResponse> randomUser(@Query("results") int size);
}
