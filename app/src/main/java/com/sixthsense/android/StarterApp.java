package com.sixthsense.android;

import android.app.Application;

import com.sixthsense.android.di.component.DaggerNetworkComponent;
import com.sixthsense.android.di.component.DaggerSharedPrefComponent;
import com.sixthsense.android.di.component.NetworkComponent;
import com.sixthsense.android.di.component.SharedPrefComponent;
import com.sixthsense.android.di.module.NetworkModule;
import com.sixthsense.android.di.module.SharedPrefModule;

public class StarterApp extends Application {


    private static StarterApp applicationInstance;

    private NetworkComponent mNetworkComponent;

    private SharedPrefComponent mSharePreference;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationInstance = this;


        mNetworkComponent = DaggerNetworkComponent.builder()
                .networkModule(new NetworkModule())
                .build();

        mSharePreference = DaggerSharedPrefComponent.builder()
                .sharedPrefModule(new SharedPrefModule())
                .build();
    }

    public static StarterApp getApplicationInstance() {
        return applicationInstance;
    }

    public NetworkComponent getNetworkComponent(){
        return mNetworkComponent;
    }

    public SharedPrefComponent getmSharePreference() {
        return mSharePreference;
    }

}
