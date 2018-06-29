package com.sixthsense.kwickmove.domain.repository.onboard;

import com.sixthsense.kwickmove.KwickMoveApp;
import com.sixthsense.kwickmove.base.BaseView;
import com.sixthsense.kwickmove.domain.IRestApis;
import com.sixthsense.kwickmove.domain.SingleObserverWrapper;
import com.sixthsense.kwickmove.domain.repository.IBaseRepository;
import com.sixthsense.kwickmove.onboard.User;

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
        KwickMoveApp.getApplicationInstance().getNetworkComponent().inject(this);
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
