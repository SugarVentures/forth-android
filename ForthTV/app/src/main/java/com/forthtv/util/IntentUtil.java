package com.forthtv.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by cuongvo on 1/12/16.
 */
public class IntentUtil {
    public enum NavigationUtil {
        OPEN_LANDING(1, "Open Landing Screen"),
        OPEN_MAIN(2, "Open Main Screen"),
        OPEN_SIGNIN(3, "Open Sign in Screen"),
        OPEN_REGISTER(4, "Open Register Screen"),
        OPEN_RECORD(5, "Open Record Screen"),
        OPEN_WATCH_VIDEO(5, "Open Watch Video Screen");

        private int id;
        private String action;

        NavigationUtil(int id, String action) {
            this.id = id;
            this.action = action;
        }

        public String getAction() {
            return this.action;
        }
    }

    public static Intent createIntent(Activity activity, Class<?> clazz, String action) {
        Intent intent = new Intent();
        intent.setAction(action);
        intent.setClass(activity, clazz);
        return intent;
    }

    public static Intent createIntentWithBundle(Activity activity, Class<?> clazz, String action, Bundle bundle) {
        Intent intent = new Intent();
        intent.setAction(action);
        intent.setClass(activity, clazz);
        intent.putExtras(bundle);
        return intent;
    }
}
