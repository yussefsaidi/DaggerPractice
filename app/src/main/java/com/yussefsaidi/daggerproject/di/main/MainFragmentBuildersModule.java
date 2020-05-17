package com.yussefsaidi.daggerproject.di.main;

import com.yussefsaidi.daggerproject.ui.main.posts.PostsFragment;
import com.yussefsaidi.daggerproject.ui.main.profile.ProfileFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract ProfileFragment contributeProfileFragment();

    @ContributesAndroidInjector
    abstract PostsFragment contributePostsFragment();

}
