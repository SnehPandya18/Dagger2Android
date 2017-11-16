package com.snehpandya.dagger2demo.di.module;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.snehpandya.dagger2demo.di.scope.RandomUserApplicationScope;
import com.snehpandya.dagger2demo.service.RandomUserService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sneh.pandya on 16/11/17.
 */

@Module()
public class RandomUserServiceModule {

    @Provides
    @RandomUserApplicationScope
    public RandomUserService randomUserService(Retrofit retrofit) {
        return retrofit.create(RandomUserService.class);
    }

    @Provides
    @RandomUserApplicationScope
    public Retrofit retrofit(GsonConverterFactory gsonConverterFactory) {
        return new Retrofit.Builder()
                .addConverterFactory(gsonConverterFactory)
                .baseUrl("https://randomuser.me/")
                .build();
    }

    @Provides
    @RandomUserApplicationScope
    public GsonConverterFactory gsonConverterFactory(Gson gson) {
        return GsonConverterFactory.create(gson);
    }

    @Provides
    @RandomUserApplicationScope
    public Gson gson(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }
}
