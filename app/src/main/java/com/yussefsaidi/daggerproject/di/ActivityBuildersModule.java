package com.yussefsaidi.daggerproject.di;

import com.yussefsaidi.daggerproject.di.auth.AuthModule;
import com.yussefsaidi.daggerproject.di.auth.AuthScope;
import com.yussefsaidi.daggerproject.di.auth.AuthViewModelsModule;
import com.yussefsaidi.daggerproject.di.main.MainFragmentBuildersModule;
import com.yussefsaidi.daggerproject.di.main.MainModule;
import com.yussefsaidi.daggerproject.di.main.MainScope;
import com.yussefsaidi.daggerproject.di.main.MainViewModelsModule;
import com.yussefsaidi.daggerproject.ui.auth.AuthActivity;
import com.yussefsaidi.daggerproject.ui.main.MainActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @AuthScope
    @ContributesAndroidInjector(
            modules = {
                    AuthViewModelsModule.class, AuthModule.class}
                    )
    abstract AuthActivity contributeAuthActivity();

    @MainScope
    @ContributesAndroidInjector(
            modules = {MainFragmentBuildersModule.class, MainViewModelsModule.class, MainModule.class}
    )
    abstract MainActivity contributeMainActivity();
}
