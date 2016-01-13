package com.forthtv.util.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
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
public class TextViewWithMessage extends LinearLayout {
    private TextView mTextViewContent;
    private TextView mTextViewMessage;

    public TextViewWithMessage(Context context) {
        super(context);
        initialize(context);
    }

    public TextViewWithMessage(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context);
    }

    public TextViewWithMessage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TextViewWithMessage(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initialize(context);
    }

    private void initialize(Context context){
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.view_textview_with_message, this);
        mTextViewContent = (TextView) view.findViewById(R.id.view_textview);
        mTextViewMessage = (TextView) view.findViewById(R.id.view_message);
    }

    public void setTextContent(String content){
        mTextViewContent.setText(content);
    }

    public void setTextHint(String hint){
        mTextViewContent.setHint(hint);
    }

    public void setMessage(String message){
        mTextViewMessage.setText(message);
    }

    public void setTextViewContentIcon(int imageResource){
        mTextViewContent.setCompoundDrawablesWithIntrinsicBounds(imageResource,0,0,0);
    }
}
