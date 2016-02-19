package com.forthtv.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.forthtv.BaseActivity;
import com.forthtv.BaseFragment;
import com.forthtv.R;
import com.forthtv.controller.fragment.LoginFragment;
import com.forthtv.controller.fragment.RegisterFragment;
import com.forthtv.util.IntentUtil;

/**
 * Created by baongoc on 12/30/15.
 */
public class AuthenticationActivity extends BaseActivity {

    private TextView mTextViewSignin;
    private TextView mTextViewRegister;
    private FrameLayout mFrameLayoutAuthCotent;

    public AuthenticationActivity() {
        mActivityType = ActivityType.ACTIVITY_AUTHENTICATION;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mTextViewRegister = (TextView) findViewById(R.id.activity_auth_register);
        mTextViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegisterFragment();
            }
        });
        mTextViewSignin = (TextView) findViewById(R.id.activity_auth_signin);
        mTextViewSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoginFragment();
            }
        });

        mFrameLayoutAuthCotent = (FrameLayout) findViewById(R.id.fragment_auth_main_content);

        Intent intent = getIntent();
        if (!TextUtils.isEmpty(intent.getAction())) {
            String screen = intent.getAction();
            navigating(screen);
        } else {
            // Display login fragment as default
            openLoginFragment();
        }

    }

    private void openRegisterFragment() {
        RegisterFragment registerFragment = new RegisterFragment();
        openFragment(registerFragment, mFrameLayoutAuthCotent.getId(), BaseFragment.FragmentType.FRAGMENT_REGISTER);
    }

    private void openLoginFragment() {
        LoginFragment loginFragment = new LoginFragment();
        openFragment(loginFragment, mFrameLayoutAuthCotent.getId(), BaseFragment.FragmentType.FRAGMENT_LOGIN);
    }

    private void navigating(String screen) {
        if (screen.equals(IntentUtil.NavigationUtil.OPEN_SIGNIN.getAction())) {
            openLoginFragment();
        } else if (screen.equals(IntentUtil.NavigationUtil.OPEN_REGISTER.getAction())) {
            openRegisterFragment();
        }
    }
}
