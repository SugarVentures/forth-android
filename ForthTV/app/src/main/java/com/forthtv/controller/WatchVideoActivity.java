package com.forthtv.controller;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.forthtv.BaseActivity;
import com.forthtv.R;
import com.forthtv.model.VideoData;
import com.forthtv.util.PicassoCircleTransformation;
import com.forthtv.util.view.VideoFooter;
import com.forthtv.util.view.VideoHeader;
import com.forthtv.util.view.VideoViewPlayer;
import com.squareup.picasso.Picasso;

/**
 * Created by baongoc on 1/12/16.
 */
public class WatchVideoActivity extends BaseActivity {
    private VideoData mVideoData;

    private ImageView mImageViewChannelAvatar;

    private VideoViewPlayer mVideoViewPlayer;
    private VideoHeader mVideoHeader;
    private VideoFooter mVideoFooter;

    public WatchVideoActivity(){
        mActivityType = ActivityType.ACTIVITY_WATCH;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mVideoViewPlayer = (VideoViewPlayer)findViewById(R.id.activity_watch_player);
        mVideoFooter = (VideoFooter)findViewById(R.id.activity_watch_video_footer);
        mVideoFooter.getTextViewFullscreen().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Going fullscreen here
            }
        });
        mVideoHeader = (VideoHeader)findViewById(R.id.activity_watch_video_header);
        mVideoHeader.getImageViewAction().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                // Need to release the media player also
            }
        });
        mImageViewChannelAvatar = (ImageView)findViewById(R.id.activity_watch_channel_avatar);
        Picasso.with(this).load(R.drawable.test_avatar_small)
                .transform(new PicassoCircleTransformation())
                .centerInside().resize(45,45)
                .into(mImageViewChannelAvatar);
        mVideoData = (VideoData) getIntent().getSerializableExtra("VideoData");
        if(mVideoData != null){
            mVideoViewPlayer.setVideoData(mVideoData);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        mVideoViewPlayer.setupSurfaceView();
        runOnUiThread(new Runnable() {
            public void run() {
                try {
                    mVideoViewPlayer.getMediaPlayer().prepare();
                    mVideoViewPlayer.getMediaPlayer().start();
                } catch (final Exception ex) {

                }
            }
        });
    }
}
