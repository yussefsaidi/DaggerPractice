package com.yussefsaidi.daggerproject.di.auth;

import androidx.lifecycle.ViewModel;

import com.yussefsaidi.daggerproject.di.ViewModelKey;
import com.yussefsaidi.daggerproject.ui.auth.AuthViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class AuthViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel.class)
    public abstract ViewModel bindAuthViewModel(AuthViewModel viewModel);

}
