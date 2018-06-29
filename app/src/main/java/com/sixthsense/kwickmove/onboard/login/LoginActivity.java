package com.sixthsense.kwickmove.onboard.login;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import com.sixthsense.kwickmove.base.BaseActivity;
import com.sixthsense.rideshareapp.R;
import com.sixthsense.rideshareapp.databinding.ActivityLoginBinding;

public class LoginActivity extends BaseActivity {


    private ActivityLoginBinding mBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinder = (ActivityLoginBinding) setLayout(R.layout.activity_login);

        mBinder.password.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == EditorInfo.IME_ACTION_DONE || id == EditorInfo.IME_NULL) {
                    return true;
                }
                return false;
            }
        });

        mBinder.emailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

    }


    @Override
    public void showError(String msg, byte requestCode) {

    }
}

