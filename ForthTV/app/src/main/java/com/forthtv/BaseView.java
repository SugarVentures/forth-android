package com.forthtv;

import android.content.Context;
import android.view.LayoutInflater;

/**
 * Created by cuongvo on 1/20/16.
 */
public abstract class BaseView {
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public void initialize(Context context){
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }
}
