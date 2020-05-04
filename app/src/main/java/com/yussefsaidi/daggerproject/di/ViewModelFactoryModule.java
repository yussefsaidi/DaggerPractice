package com.yussefsaidi.daggerproject.di;

import androidx.lifecycle.ViewModelProvider;

import com.yussefsaidi.daggerproject.viewmodels.ViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelFactoryModule {

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory viewModelProviderFactory);

}
