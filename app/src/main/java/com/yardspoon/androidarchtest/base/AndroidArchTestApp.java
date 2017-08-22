package com.yardspoon.androidarchtest.base;

import android.app.Activity;
import android.app.Application;
import android.util.Log;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;


public class AndroidArchTestApp extends Application implements HasActivityInjector {
    @Override public void onCreate() {
        super.onCreate();

        Log.i(AndroidArchTestApp.class.getSimpleName(), "onCreate");

        DaggerAppDIComponent.create().inject(this);
    }

    @Inject DispatchingAndroidInjector<Activity> dispatchingActivityInjector;

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingActivityInjector;
    }
}
