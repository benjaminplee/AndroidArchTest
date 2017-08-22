package com.yardspoon.androidarchtest.base;


import android.content.Context;

import com.yardspoon.androidarchtest.external.HttpBinApi;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Singleton
@Module()
public abstract class AppDIModule {
    @Provides static Context provideContext(AndroidArchTestApp application) {
        return application.getApplicationContext();
    }

    @Singleton
    @Provides static OkHttpClient providesOkHttpClient() {
        final int TIMEOUT = 10;

        return new OkHttpClient.Builder()
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true).build();
    }

    @Singleton
    @Provides static Retrofit providesRetrofitBuilder(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl("https://httpbin.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .client(okHttpClient)
                .build();
    }

    @Singleton
    @Provides static HttpBinApi providesHttpBinAPI(Retrofit builder) {
        return builder.create(HttpBinApi.class);
    }
}
