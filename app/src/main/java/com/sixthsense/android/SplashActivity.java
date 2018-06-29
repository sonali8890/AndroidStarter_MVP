package com.sixthsense.android;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sixthsense.android.onboard.login.LoginActivity;
import com.starterapp.android.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        launchNext();
    }

    private void launchNext() {

        long LAUNCH_NEXT_SCREEN_DELAY = 3000;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
            }
        }, LAUNCH_NEXT_SCREEN_DELAY);
    }
}
