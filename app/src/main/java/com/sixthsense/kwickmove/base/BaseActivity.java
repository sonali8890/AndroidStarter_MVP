package com.sixthsense.kwickmove.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;

import com.sixthsense.rideshareapp.R;
import com.sixthsense.rideshareapp.databinding.ActivityBaseBinding;

public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    ActivityBaseBinding mBinder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinder = DataBindingUtil.setContentView(this, R.layout.activity_base);
//        setSupportActionBar(mBinder.toolbar);

    }

    protected ViewDataBinding setLayout(int layout){
        ViewDataBinding binder = DataBindingUtil.inflate(LayoutInflater.from(this), layout, mBinder.container, false);
        mBinder.container.addView(binder.getRoot());
        return binder;
    }

    protected void setActivityTitle(int title){
        mBinder.toolbar.setTitle(getString(title));
    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }
}
