package com.sixthsense.kwickmove.domain;

import com.sixthsense.kwickmove.domain.repository.onboard.SignUpRequestBean;
import com.sixthsense.kwickmove.onboard.User;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;


public interface IRestApis {

    @GET("signup")
    Single<User> signup(@Body SignUpRequestBean body);


}
