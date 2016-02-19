package com.forthtv.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import com.forthtv.model.AndroidAppData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cuongvo on 2/19/16.
 */
public class AndroidUtil {

    public static List<AndroidAppData> getListOfInstalledAppOnDevice(Context context){
        List<AndroidAppData> list = new ArrayList<AndroidAppData>();
        AndroidAppData androidAppData = null;

        final PackageManager pm = context.getPackageManager();
        //get a list of installed apps.
        List<ApplicationInfo> packages = pm.getInstalledApplications(PackageManager.GET_META_DATA);

        for (ApplicationInfo packageInfo : packages) {
            androidAppData = new AndroidAppData();
            androidAppData.setInstalledPackage(packageInfo.packageName);
            androidAppData.setLaunchActivity(pm.getLaunchIntentForPackage(packageInfo.packageName).toString());

            Log.d("AndroidUtil", "Installed package :" + packageInfo.packageName);
            Log.d("AndroidUtil", "Source dir : " + packageInfo.sourceDir);
            Log.d("AndroidUtil", "Launch Activity :" + pm.getLaunchIntentForPackage(packageInfo.packageName));
            list.add(androidAppData);
        }

        return list;
    }
}
