package com.sixthsense.android.domain;


import android.text.TextUtils;

import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;
import com.sixthsense.android.base.BaseView;
import com.sixthsense.android.constants.MessageConstants;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public abstract class SingleObserverWrapper<T extends BaseResponse> implements SingleObserver<T> {

    private BaseView view;
    private byte requestCode;

    public SingleObserverWrapper(BaseView view, byte requestCode) {
        this.view = view;
        this.requestCode = requestCode;
    }

    public SingleObserverWrapper(BaseView view) {
        this.view = view;
    }


    protected abstract void onTaskSuccess(T t);

    @Override
    public void onSubscribe(Disposable d) {
    }

    @Override
    public void onSuccess(T t) {
        view.hideProgress();
        BaseResponse res = t;
        if (res == null) {
            onError(new Throwable(MessageConstants.INTERNAL_SERVER_ERROR));
        } else if (res.isValid()) {
            onTaskSuccess(t);
        }  else if (!TextUtils.isEmpty(res.getError())) {
            onError(res.getError());
        } else {
            onError(new Throwable(MessageConstants.INTERNAL_SERVER_ERROR));
        }
    }

    @Override
    public void onError(Throwable t) {
        view.hideProgress();
        if (t instanceof NoInternetConnectionException) {
        } else if (t instanceof HttpException) {
            onError(MessageConstants.INTERNAL_SERVER_ERROR);
        } else {
            onError(t.getMessage());
        }
    }


    public void onError(String title) {
        view.hideProgress();
        view.showError(title, requestCode);
    }

}
