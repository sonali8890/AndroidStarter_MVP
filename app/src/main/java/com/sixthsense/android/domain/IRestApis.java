package com.sixthsense.android.domain;

import com.sixthsense.android.domain.repository.onboard.SignUpRequestBean;
import com.sixthsense.android.onboard.User;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;


public interface IRestApis {

    @GET("signup")
    Single<User> signup(@Body SignUpRequestBean body);


}
