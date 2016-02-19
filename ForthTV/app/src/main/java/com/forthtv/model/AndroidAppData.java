package com.forthtv.model;

/**
 * Created by cuongvo on 2/19/16.
 */
public class AndroidAppData {
    private String installedPackage;
    private String launchActivity;

    public String getInstalledPackage() {
        return installedPackage;
    }

    public void setInstalledPackage(String installedPackage) {
        this.installedPackage = installedPackage;
    }

    public String getLaunchActivity() {
        return launchActivity;
    }

    public void setLaunchActivity(String launchActivity) {
        this.launchActivity = launchActivity;
    }
}
