package com.sixthsense.kwickmove.di.module;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.sixthsense.kwickmove.KwickMoveApp;
import com.sixthsense.kwickmove.constants.APIConstants;
import com.sixthsense.kwickmove.network.NoInternetConnectionException;
import com.sixthsense.rideshareapp.BuildConfig;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
public class NetworkModule {

    @Provides
    public Interceptor provideHeaderInterceptor() {

        return new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder()
                        .addHeader("Accept", "Application/JSON")
                        .addHeader("Content-Type", "Application/JSON")
                        .build();

                if (isNetworkConnected()) {
                    return chain.proceed(request);
                } else {
                    throw new NoInternetConnectionException();
                }
            }
        };

    }

    @Provides
    public HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

    @Provides
    OkHttpClient provideOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor, Interceptor headerInterceptor) {

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(APIConstants.TIME_OUT_SECS, TimeUnit.SECONDS)
                .readTimeout(APIConstants.TIME_OUT_SECS, TimeUnit.SECONDS)
                .addInterceptor(headerInterceptor);

        if (BuildConfig.DEBUG) {
            builder.addInterceptor(httpLoggingInterceptor);
        }
        return builder.build();
    }


    @Provides
    @Singleton
    @Named("BaseUrl")
    Retrofit provideBaseRetrofit(OkHttpClient okHttpClient) {

        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }


    public boolean isNetworkConnected() {
        ConnectivityManager cm =
                (ConnectivityManager) KwickMoveApp.getApplicationInstance().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
    }

}
