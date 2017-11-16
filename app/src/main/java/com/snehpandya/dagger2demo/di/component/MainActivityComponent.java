package com.snehpandya.dagger2demo.di.component;

import com.snehpandya.dagger2demo.di.module.MainActivityModule;
import com.snehpandya.dagger2demo.di.scope.MainActivityScope;
import com.snehpandya.dagger2demo.view.MainActivity;

import dagger.Component;

/**
 * Created by sneh.pandya on 16/11/17.
 */

@MainActivityScope
@Component(modules = {MainActivityModule.class}, dependencies = {RandomUserApplicationComponent.class})
public interface MainActivityComponent {

    void injectMainActivity(MainActivity mainActivity);
}
