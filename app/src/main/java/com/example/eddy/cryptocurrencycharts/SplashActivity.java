package com.example.eddy.cryptocurrencycharts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends Activity {

    private final int SPLASH_LENGTH = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                startActivity(new Intent(SplashActivity.this, CurrencyListActivity.class));
                SplashActivity.this.finish();
            }
        }, SPLASH_LENGTH);
    }
}
