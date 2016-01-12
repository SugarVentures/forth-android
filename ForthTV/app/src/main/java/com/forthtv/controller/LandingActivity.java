package com.forthtv.controller;

import android.os.Bundle;

import com.forthtv.BaseActivity;
import com.forthtv.util.IntentUtil;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by baongoc on 1/12/16.
 */
public class LandingActivity extends BaseActivity {

    public LandingActivity(){
        mActivityType = ActivityType.ACTIVITY_LANDING;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showUp();
    }

    private void showUp(){
        Timer timer = new Timer();
        timer.schedule(timerTask, 4000);
    }

    private TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            startActivity(IntentUtil.createIntent(LandingActivity.this,AuthenticationActivity.class,"Open Authentication"));
        }
    };
}
