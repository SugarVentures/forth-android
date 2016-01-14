package com.forthtv.util.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.forthtv.R;

/**
 * Created by cuongvo on 1/14/16.
 */
public class AppToolbar extends FrameLayout {
    private Context mContext;
    private TextView mTextViewTitle;
    private ImageView mImageViewActionLeft;
    private ImageView mImageViewActionRight;

    public AppToolbar(Context context) {
        super(context);
        initialize(context);
    }

    public AppToolbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context);

    }

    public AppToolbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(context);

    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public AppToolbar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initialize(context);

    }

    private void initialize(Context context) {
        this.mContext = context;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.view_toolbar_with_title, this);
        mTextViewTitle = (TextView) view.findViewById(R.id.view_toolbar_title);
        mImageViewActionLeft = (ImageView) view.findViewById(R.id.view_toolbar_action_left);
        mImageViewActionRight = (ImageView) view.findViewById(R.id.view_toolbar_action_right);

    }

    public void setTitle(String title, boolean isCentered) {
        mTextViewTitle.setText(title);
        if (isCentered) {
            mTextViewTitle.setLayoutParams(getCenteredLinearLayoutGravity());
        } else {
            mTextViewTitle.setLayoutParams(getLeftLinearLayoutGravity());
        }
    }

    public void setActionLeftImage(int imageResource) {
        mImageViewActionLeft.setImageResource(imageResource);
    }

    public void setActionRightImage(int imageResource) {
        mImageViewActionRight.setImageResource(imageResource);
    }

    public void displayActionLeft(boolean display) {
        if (display) {
            mImageViewActionLeft.setVisibility(View.VISIBLE);
        } else {
            mImageViewActionLeft.setVisibility(View.GONE);
        }
    }

    public void displayActionRight(boolean display) {
        if (display) {
            mImageViewActionRight.setVisibility(View.VISIBLE);
        } else {
            mImageViewActionRight.setVisibility(View.GONE);
        }
    }

    public ImageView getImageViewActionLeft() {
        return mImageViewActionLeft;
    }

    public void setImageViewActionLeft(ImageView mImageViewActionLeft) {
        this.mImageViewActionLeft = mImageViewActionLeft;
    }

    public ImageView getImageViewActionRight() {
        return mImageViewActionRight;
    }

    public void setImageViewActionRight(ImageView mImageViewActionRight) {
        this.mImageViewActionRight = mImageViewActionRight;
    }

    public static Toolbar.LayoutParams getCenteredLinearLayoutGravity() {
        Toolbar.LayoutParams params = new Toolbar.LayoutParams(Toolbar.LayoutParams.WRAP_CONTENT
                , LinearLayout.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER;

        return params;
    }

    public static Toolbar.LayoutParams getLeftLinearLayoutGravity() {
        Toolbar.LayoutParams params = new Toolbar.LayoutParams(Toolbar.LayoutParams.WRAP_CONTENT
                , LinearLayout.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.LEFT;

        return params;
    }
}
