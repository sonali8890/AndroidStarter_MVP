package com.sixthsense.android.domain.repository.onboard;

import com.sixthsense.android.StarterApp;
import com.sixthsense.android.base.BaseView;
import com.sixthsense.android.domain.IRestApis;
import com.sixthsense.android.domain.SingleObserverWrapper;
import com.sixthsense.android.domain.repository.IBaseRepository;
import com.sixthsense.android.onboard.User;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class UserOnBoardRepository implements IBaseRepository {

    @Inject
    Retrofit retrofit;

    private BaseView mView;
    private IRestApis mApis;

    public UserOnBoardRepository(BaseView view) {
        mView = view;
        mApis = retrofit.create(IRestApis.class);
        injectDependency();
    }

    @Override
    public void injectDependency() {
        StarterApp.getApplicationInstance().getNetworkComponent().inject(this);
    }


    public void userSignUp(SignUpRequestBean request) {
        mView.showProgress();
        mApis.signup(request)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new SingleObserverWrapper<User>(mView) {
                    @Override
                    protected void onTaskSuccess(User user) {

                    }
                });
    }
}
