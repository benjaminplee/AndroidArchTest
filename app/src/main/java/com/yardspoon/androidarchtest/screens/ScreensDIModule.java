package com.yardspoon.androidarchtest.screens;


import com.yardspoon.androidarchtest.screens.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ScreensDIModule {
    @ContributesAndroidInjector()
    abstract MainActivity contributeYourActivityInjector();
}
