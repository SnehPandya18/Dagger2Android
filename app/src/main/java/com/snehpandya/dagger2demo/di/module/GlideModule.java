package com.snehpandya.dagger2demo.di.module;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.snehpandya.dagger2demo.di.scope.RandomUserApplicationScope;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sneh.pandya on 16/11/17.
 */

    //TODO: 05. Define Modules

    //TODO: 11. Annotate with ApplicationScope, together with @Provides where dependency needs to act as Singleton

    //TODO: 14. Use Application context with @Named annotation

@Module(includes = {ContextModule.class})
public class GlideModule {

    @Provides
    @RandomUserApplicationScope
    public Glide glide(@Named("application_context") Context context) {
        return new GlideBuilder().build(context.getApplicationContext());
    }
}
