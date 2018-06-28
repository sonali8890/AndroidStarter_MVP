package com.sixthsense.kwickmove.di.component;


import com.sixthsense.kwickmove.di.module.SharedPrefModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {SharedPrefModule.class})
public interface SharedPrefComponent {

}
