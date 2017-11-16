package com.snehpandya.dagger2demo.di.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by sneh.pandya on 16/11/17.
 */

    //TODO: 09. Define @Scope for single instantiation of dependencies

@Scope
@Retention(RetentionPolicy.CLASS)
public @interface RandomUserApplicationScope {
}
