package com.sixthsense.android.di.module;

import android.content.Context;
import android.content.SharedPreferences;

import com.sixthsense.android.StarterApp;
import com.sixthsense.android.constants.AppConstants;

import javax.inject.Singleton;

import dagger.Module;


@Singleton
@Module
public class SharedPrefModule {


    private static SharedPreferences.Editor mEditor;
    private SharedPreferences mSharedPrefs;
    private SharedPrefModule mPref;

    public SharedPrefModule() {
        mSharedPrefs = StarterApp.getApplicationInstance().getSharedPreferences(AppConstants.SHARED_PREFS, Context.MODE_PRIVATE);
        mEditor = mSharedPrefs.edit();
    }


}