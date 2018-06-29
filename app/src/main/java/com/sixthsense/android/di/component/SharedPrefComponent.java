package com.sixthsense.android.di.component;


import com.sixthsense.android.di.module.SharedPrefModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {SharedPrefModule.class})
public interface SharedPrefComponent {

}
