package com.sixthsense.android.domain;


import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;
import com.sixthsense.android.base.BaseView;
import com.sixthsense.android.constants.MessageConstants;

import io.reactivex.observers.DisposableObserver;

public abstract class CallbackWrapper<T extends BaseResponse> extends DisposableObserver<T> {

    private BaseView view;

    public CallbackWrapper(BaseView view) {
        this.view = view;
    }

    @Override
    public void onNext(T t) {
        view.hideProgress();
        BaseResponse res = t;
        if (res.isValid()) {
            onSuccess(t);
        } else {
            onError(new Throwable(MessageConstants.INTERNAL_SERVER_ERROR));
        }
    }

    public void onError(String title) {
        view.hideProgress();
        view.showError(title);
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

    @Override
    public void onComplete() {
    }

    protected abstract void onSuccess(T t);

}
