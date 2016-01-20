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
 * Created by baongoc on 1/20/16.
 */
public class VideoHeader extends RelativeLayout {
    private Context mContext;
    private TextView mTextViewTitle;
    private ImageView mImageViewAction;

    public VideoHeader(Context context) {
        super(context);
        initialize(context);
    }

    public VideoHeader(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context);

    }

    public VideoHeader(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(context);

    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public VideoHeader(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initialize(context);

    }

    public void initialize(Context context){
        this.mContext = context;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.view_player_header, this);
        mImageViewAction = (ImageView)view.findViewById(R.id.view_player_header_action);
        mTextViewTitle = (TextView)view.findViewById(R.id.view_player_header_title);
    }


    public TextView getTextViewTitle() {
        return mTextViewTitle;
    }

    public void setTextViewTitle(TextView title) {
        this.mTextViewTitle = mTextViewTitle;
    }

    public ImageView getImageViewAction() {
        return mImageViewAction;
    }

    public void setImageViewAction(ImageView action) {
        this.mImageViewAction = mImageViewAction;
    }
}
