package com.forthtv.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by cuongvo on 1/12/16.
 */
public class IntentUtil {
    public static Intent createIntent(Activity activity, Class<?> clazz, String action){
        Log.d("Flow", "IntentUtil createIntent");

        Intent intent = new Intent();
        intent.setAction(action);
        intent.setClass(activity,clazz);
        return intent;
    }

    public static Intent createIntentWithBundle(Activity activity, Class<?> clazz, String action, Bundle bundle){
        Log.d("Flow", "IntentUtil createIntentWithBundle");

        Intent intent = new Intent();
        intent.setAction(action);
        intent.setClass(activity,clazz);
        intent.putExtras(bundle);
        return intent;
    }
}
