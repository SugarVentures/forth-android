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
        OPEN_LANDING(001, "Open Landing Screen"),
        OPEN_MAIN(002, "Open Main Screen"),
        OPEN_SIGNIN(003, "Open Sign in Screen"),
        OPEN_REGISTER(004, "Open Register Screen"),
        OPEN_RECORD(005, "Open Record Screen"),
        OPEN_WATCH_VIDEO(006, "Open Watch Video Screen"),
        OPEN_SEARCH(007,"Open Search Screen");

        private int id;
        private String action;

        NavigationUtil(int id, String action) {
            this.id = id;
            this.action = action;
        }

        public String getAction() {
            return this.action;
        }

        public int getId(){
            return this.id;
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
