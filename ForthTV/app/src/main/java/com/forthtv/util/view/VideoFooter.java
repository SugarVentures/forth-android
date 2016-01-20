package com.forthtv.util.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.forthtv.R;

/**
 * Created by cuongvo on 1/20/16.
 */
public class VideoFooter extends RelativeLayout {
    private Context mContext;
    private TextView mTextViewDuration;
    private ImageView mTextViewFullscreen;

    public VideoFooter(Context context) {
        super(context);
        initialize(context);
    }

    public VideoFooter(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context);

    }

    public VideoFooter(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(context);

    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public VideoFooter(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initialize(context);

    }

    public void initialize(Context context) {
        this.mContext = context;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.view_player_footer, this);
        mTextViewFullscreen = (ImageView)view.findViewById(R.id.view_player_footer_fullscreen);
    }


    public TextView getTextViewDuration() {
        return mTextViewDuration;
    }

    public void setTextViewDuration(TextView duration) {
        this.mTextViewDuration = duration;
    }

    public ImageView getTextViewFullscreen() {
        return mTextViewFullscreen;
    }

    public void setTextViewFullscreen(ImageView fullscreen) {
        this.mTextViewFullscreen = fullscreen;
    }
}
