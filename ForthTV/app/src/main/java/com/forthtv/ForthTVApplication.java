package com.forthtv;

import android.app.Application;

/**
 * Created by baongoc on 12/30/15.
 */
public class ForthTVApplication extends Application {

    private static ForthTVApplication mForthTVApplication;

    public static ForthTVApplication getInstance(){
        return mForthTVApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        this.mForthTVApplication = this;
    }
}
