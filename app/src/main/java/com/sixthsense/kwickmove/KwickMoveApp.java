package com.sixthsense.kwickmove;

import android.app.Application;
import android.content.Context;

import com.sixthsense.kwickmove.di.component.DaggerNetworkComponent;
import com.sixthsense.kwickmove.di.component.DaggerSharedPrefComponent;
import com.sixthsense.kwickmove.di.component.NetworkComponent;
import com.sixthsense.kwickmove.di.component.SharedPrefComponent;
import com.sixthsense.kwickmove.di.module.NetworkModule;
import com.sixthsense.kwickmove.di.module.SharedPrefModule;

public class KwickMoveApp extends Application {


    private static Context applicationInstance;

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

    public static Context getApplicationInstance() {
        return applicationInstance;
    }

    public NetworkComponent getNetworkComponent(){
        return mNetworkComponent;
    }

    public SharedPrefComponent getmSharePreference() {
        return mSharePreference;
    }

}
