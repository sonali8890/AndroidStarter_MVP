package com.sixthsense.kwickmove.network;

import java.io.IOException;

/**
 * Created by Sonali
 */

public class NoInternetConnectionException extends IOException {

    public NoInternetConnectionException() {
        super("No Internet Connection");
    }
}