package com.snehpandya.dagger2demo.di.module;

import android.content.Context;

import com.snehpandya.dagger2demo.di.scope.RandomUserApplicationScope;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sneh.pandya on 16/11/17.
 */

    //TODO: 06. Define ContextModule (Because its top level independent dependency) & include it in required modules for dependencies

    //TODO: 07. Compile the project

@Module
public class ContextModule {

    public final Context mContext;

    public ContextModule(Context context) { this.mContext = context; }

    @Provides
    @RandomUserApplicationScope
    @Named("application_context")
    public Context context() {
        return mContext;
    }
}
