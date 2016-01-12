package com.forthtv.controller.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.forthtv.BaseFragment;
import com.forthtv.R;
import com.forthtv.util.view.TextFieldWithMessage;

/**
 * Created by baongoc on 12/30/15.
 */
public class LoginFragment extends BaseFragment {

    private TextFieldWithMessage mTextFieldWithMessageEmail;
    private TextFieldWithMessage mTextFieldWithMessagePassword;

    public LoginFragment(){
        mFragmentType = FragmentType.FRAGMENT_LOGIN;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        mTextFieldWithMessageEmail = (TextFieldWithMessage)view.findViewById(R.id.fragment_login_email);
        mTextFieldWithMessageEmail.setTextFieldHint("EMAIL");

        mTextFieldWithMessagePassword = (TextFieldWithMessage)view.findViewById(R.id.fragment_login_password);
        mTextFieldWithMessagePassword.setTextFieldHint("PASSWORD");
        mTextFieldWithMessagePassword.setTextFieldType(true);

        return view;
    }
}
