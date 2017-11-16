package com.snehpandya.dagger2demo.di.module;

import android.app.Activity;
import android.content.Context;

import com.snehpandya.dagger2demo.di.scope.RandomUserApplicationScope;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sneh.pandya on 16/11/17.
 */

    //TODO: 12. ActivityModule for Activity level context, which is different from Application level context

    //TODO: 13. Annotate with @Named to distinct Application context with Activity context

@Module
public class ActivityModule {

    private final Context mContext;

    public ActivityModule(Activity context) {
        this.mContext = context;
    }

    @Provides
    @RandomUserApplicationScope
    @Named("activity_context")
    public Context context() { return mContext; }
}
