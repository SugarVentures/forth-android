package com.forthtv;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by baongoc on 12/30/15.
 */
public class BaseFragment extends Fragment {

    public enum FragmentType {
        FRAGMENT_LOGIN(1, R.layout.fragment_login, "FRAGMENT_LOGIN"),
        FRAGMENT_REGISTER(1, R.layout.fragment_register, "FRAGMENT_REGISTER");

        private int id;
        private int layoutId;
        private String name;

        FragmentType(int id, int layoutId, String name) {
            this.id = id;
            this.layoutId = layoutId;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getLayoutId() {
            return layoutId;
        }

        public void setLayoutId(int layoutId) {
            this.layoutId = layoutId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    protected Context mContext;
    protected FragmentType mFragmentType;
    protected View mContainer;

    public BaseFragment() {
    }

    @SuppressLint("ValidFragment")
    public BaseFragment(Context context) {
        this.mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContainer = inflater.inflate(mFragmentType.getLayoutId(), container, false);
        return mContainer;
    }

    public Context getContext() {
        return mContext;
    }

    public void setContext(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }
}
