package com.sixthsense.kwickmove.di.component;


import com.sixthsense.kwickmove.di.module.NetworkModule;
import com.sixthsense.kwickmove.domain.repository.onboard.UserOnBoardRepository;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class})
public interface NetworkComponent {


    void inject(UserOnBoardRepository repository);
}
