package com.yardspoon.androidarchtest.base;

import com.yardspoon.androidarchtest.screens.ScreensDIModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        AppDIModule.class,
        ScreensDIModule.class})
public interface AppDIComponent {
    void inject(AndroidArchTestApp application);
}

