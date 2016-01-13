package com.forthtv.controller.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.forthtv.BaseFragment;
import com.forthtv.R;
import com.forthtv.util.view.TextFieldWithMessage;
import com.forthtv.util.view.TextViewWithMessage;

/**
 * Created by cuongvo on 12/30/15.
 */
public class RegisterFragment extends BaseFragment {

    private TextFieldWithMessage mTextFieldWithMessageUserName;
    private TextFieldWithMessage mTextFieldWithMessageEmail;
    private TextFieldWithMessage mTextFieldWithMessagePassword;
    private TextViewWithMessage mTextViewWithMessageDateOfBirth;

    public RegisterFragment() {
        mFragmentType = FragmentType.FRAGMENT_REGISTER;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        mTextFieldWithMessageUserName = (TextFieldWithMessage)view.findViewById(R.id.fragment_register_username);
        mTextFieldWithMessageUserName.setTextFieldHint("USER NAME");
        mTextFieldWithMessageUserName.setTextfieldIcon(R.drawable.icon_username);
        mTextFieldWithMessageUserName.setTextMessage("User name is incorrect!");

        mTextFieldWithMessageEmail =(TextFieldWithMessage)view.findViewById(R.id.fragment_register_email);
        mTextFieldWithMessageEmail.setTextfieldIcon(R.drawable.icon_email);
        mTextFieldWithMessageEmail.setTextFieldHint("EMAIL");

        mTextFieldWithMessagePassword = (TextFieldWithMessage)view.findViewById(R.id.fragment_register_password);
        mTextFieldWithMessagePassword.setTextFieldHint("PASSWORD");
        mTextFieldWithMessagePassword.setTextfieldIcon(R.drawable.icon_password);
        mTextFieldWithMessagePassword.setTextFieldType(true);

        mTextViewWithMessageDateOfBirth = (TextViewWithMessage)view.findViewById(R.id.fragment_register_date_of_birth);
        mTextViewWithMessageDateOfBirth.setTextViewContentIcon(R.drawable.icon_birthday);
        mTextViewWithMessageDateOfBirth.setTextHint("DATE OF BIRTH");

        return view;
    }
}
