package com.snehpandya.dagger2demo.di.component;

import com.bumptech.glide.Glide;
import com.snehpandya.dagger2demo.di.module.ActivityModule;
import com.snehpandya.dagger2demo.di.module.GlideModule;
import com.snehpandya.dagger2demo.di.module.RandomUserServiceModule;
import com.snehpandya.dagger2demo.di.scope.RandomUserApplicationScope;
import com.snehpandya.dagger2demo.service.RandomUserService;

import dagger.Component;

/**
 * Created by sneh.pandya on 16/11/17.
 */

    //TODO: 04. Define ApplicationComponent

    //TODO: 10. Annotate with ApplicationScope, add ActivityModule.class in `modules`

@RandomUserApplicationScope
@Component(modules = {RandomUserServiceModule.class, GlideModule.class, ActivityModule.class})
public interface RandomUserApplicationComponent {

    Glide glide();

    RandomUserService randomUserService();
}
