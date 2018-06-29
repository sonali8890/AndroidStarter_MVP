package com.sixthsense.android.di.component;


import com.sixthsense.android.di.module.NetworkModule;
import com.sixthsense.android.domain.repository.onboard.UserOnBoardRepository;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class})
public interface NetworkComponent {


    void inject(UserOnBoardRepository repository);
}
