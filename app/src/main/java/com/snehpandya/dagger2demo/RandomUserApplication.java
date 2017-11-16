package com.snehpandya.dagger2demo;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.snehpandya.dagger2demo.di.component.DaggerRandomUserApplicationComponent;
import com.snehpandya.dagger2demo.di.component.RandomUserApplicationComponent;
import com.snehpandya.dagger2demo.di.module.ContextModule;

import timber.log.Timber;

/**
 * Created by sneh.pandya on 16/11/17.
 */

    //TODO: 17. Implement ApplicationComponent in Application class

public class RandomUserApplication extends Application {

    private RandomUserApplicationComponent mRandomUserApplicationComponent;

    public static RandomUserApplication get(Activity activity) {
        return (RandomUserApplication) activity.getApplication();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Context context = this;

        Timber.plant(new Timber.DebugTree());

        //TODO: 08. Implement DaggerComponent logic & calling methods

        mRandomUserApplicationComponent = DaggerRandomUserApplicationComponent.builder()
                .contextModule(new ContextModule(this)).build();
    }

    public RandomUserApplicationComponent getRandomUserApplicationComponent() {
        return mRandomUserApplicationComponent;
    }
}
