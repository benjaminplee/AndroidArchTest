package com.yardspoon.androidarchtest.screens.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.yardspoon.androidarchtest.R;
import com.yardspoon.androidarchtest.external.HttpBinApi;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class MainActivity extends AppCompatActivity {
    @Inject HttpBinApi api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View webButton = findViewById(R.id.webButton);
        webButton.setOnClickListener(view -> api.ip().observeOn(AndroidSchedulers.mainThread()).subscribe(MainActivity.this::onIPResponse, MainActivity.this::onError));
    }

    private void onIPResponse(HttpBinApi.IpResponse response) {
        Log.i(MainActivity.class.getSimpleName(), "IP: " + response.origin);
    }

    private void onError(Throwable t) {
        Log.e(MainActivity.class.getSimpleName(), "Error", t);
    }
}
