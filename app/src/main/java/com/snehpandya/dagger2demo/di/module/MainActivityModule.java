package com.snehpandya.dagger2demo.di.module;

import com.snehpandya.dagger2demo.di.scope.MainActivityScope;
import com.snehpandya.dagger2demo.view.MainActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sneh.pandya on 16/11/17.
 */

@Module
public class MainActivityModule {

    private final MainActivity mMainActivity;

    public MainActivityModule(MainActivity mainActivity) {
        this.mMainActivity = mainActivity;
    }

    @Provides
    @MainActivityScope
    MainActivity mainActivity() {
        return mMainActivity;
    }
}
