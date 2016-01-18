package com.forthtv.controller;

import android.os.Bundle;

import com.forthtv.BaseActivity;
import com.forthtv.R;
import com.forthtv.model.VideoData;
import com.forthtv.util.view.VideoViewPlayer;

/**
 * Created by baongoc on 1/12/16.
 */
public class WatchVideoActivity extends BaseActivity {
    private VideoData mVideoData;
    private VideoViewPlayer mVideoViewPlayer;

    public WatchVideoActivity(){
        mActivityType = ActivityType.ACTIVITY_WATCH;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mVideoViewPlayer = (VideoViewPlayer)findViewById(R.id.activity_watch_player);

        mVideoData = (VideoData) getIntent().getSerializableExtra("VideoData");
        if(mVideoData != null){
            mVideoViewPlayer.setVideoData(mVideoData);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        mVideoViewPlayer.setupSurfaceView();
        // work on UiThread for better performance
        runOnUiThread(new Runnable() {
            public void run() {
                // If there are stories, add them to the table
                try {
                    mVideoViewPlayer.getMediaPlayer().prepare();
                    mVideoViewPlayer.getMediaPlayer().start();
                } catch (final Exception ex) {
                    // Log.i("---","Exception in thread");
                }
            }
        });
    }
}
