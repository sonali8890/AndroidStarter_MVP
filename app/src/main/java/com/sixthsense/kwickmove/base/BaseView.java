package com.sixthsense.kwickmove.base;

public interface BaseView {

    void showProgress();
    void hideProgress();
    void showError(String msg);
    void showError(String msg, byte requestCode);

}
