package com.sixthsense.kwickmove.di.module;

import android.content.Context;
import android.content.SharedPreferences;

import com.sixthsense.kwickmove.KwickMoveApp;
import com.sixthsense.kwickmove.constants.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Singleton
@Module
public class SharedPrefModule {


    private static SharedPreferences.Editor mEditor;
    private SharedPreferences mSharedPrefs;
    private SharedPrefModule mPref;

    public SharedPrefModule() {
        mSharedPrefs = KwickMoveApp.getApplicationInstance().getSharedPreferences(AppConstants.SHARED_PREFS, Context.MODE_PRIVATE);
        mEditor = mSharedPrefs.edit();
    }


}