package com.forthtv.util.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.forthtv.R;

/**
 * Created by cuongvo on 1/12/16.
 */
public class TextFieldWithMessage extends LinearLayout {
    private EditText mEditTextContent;
    private TextView mTextViewMessage;

    public TextFieldWithMessage(Context context) {
        super(context);
        initialize(context);
    }

    public TextFieldWithMessage(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context);
    }

    public TextFieldWithMessage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TextFieldWithMessage(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initialize(context);
    }

    private void initialize(Context context) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.view_textfield_with_message, this);
        mEditTextContent = (EditText) view.findViewById(R.id.view_textfield);
        mTextViewMessage = (TextView) view.findViewById(R.id.view_message);
    }

    public void setTextFieldHint(String hint) {
        mEditTextContent.setHint(hint);
    }

    public void setTextMessage(String message) {
        mTextViewMessage.setText(message);
    }

    public void setTextFieldType(boolean password){
        if(password){
            mEditTextContent.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }else{
            mEditTextContent.setInputType(InputType.TYPE_CLASS_TEXT);
        }

    }
}
