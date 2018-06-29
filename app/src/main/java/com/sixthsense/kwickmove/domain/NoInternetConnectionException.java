package com.sixthsense.kwickmove.domain;

import java.io.IOException;


public class NoInternetConnectionException extends IOException {

    public NoInternetConnectionException() {
        super("No Internet Connection");
    }
}
