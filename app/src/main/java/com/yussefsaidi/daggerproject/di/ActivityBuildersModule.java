package com.yussefsaidi.daggerproject.di;

import com.yussefsaidi.daggerproject.di.auth.AuthModule;
import com.yussefsaidi.daggerproject.di.auth.AuthViewModelsModule;
import com.yussefsaidi.daggerproject.ui.auth.AuthActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
            modules = {
                    AuthViewModelsModule.class,
                    AuthModule.class
            })
    abstract AuthActivity contributeAuthActivity();
}
