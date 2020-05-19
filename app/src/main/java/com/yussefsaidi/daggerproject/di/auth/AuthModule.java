package com.yussefsaidi.daggerproject.di.auth;

import com.yussefsaidi.daggerproject.models.User;
import com.yussefsaidi.daggerproject.network.auth.AuthApi;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class AuthModule {

    @AuthScope
    @Provides
    static AuthApi provideAuthApi(Retrofit retrofit){
        return retrofit.create(AuthApi.class);
    }

    @AuthScope
    @Provides
    @Named("auth_user")
    User provideUser1(){
        return new User();
    }

}
