package com.forthtv.util.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.Camera;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.LinearLayout;

import com.forthtv.R;
import com.forthtv.model.VideoData;
import com.forthtv.util.camera.CameraUtil;

import java.io.IOException;

/**
 * Created by cuongvo on 1/18/16.
 */
public class VideoViewPlayer extends LinearLayout implements SurfaceHolder.Callback{

    private boolean isPlaying;

    private Context mContext;
    private SurfaceView mSurfaceView;
    private MediaPlayer mMediaPlayer;
    private SurfaceHolder mSurfaceHolder;

    private VideoData mVideoData;
    private Camera.Size mVideoSize;

    public VideoViewPlayer(Context context) {
        super(context);
        initialize(context);
    }

    public VideoViewPlayer(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context);

    }

    public VideoViewPlayer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(context);

    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public VideoViewPlayer(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initialize(context);

    }

    public void initialize(Context context){
        this.mContext = context;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.view_video_player, this);
        mSurfaceView = (SurfaceView)view.findViewById(R.id.view_video_player_surfaceview);
        mSurfaceHolder = mSurfaceView.getHolder();
        mSurfaceHolder.addCallback(this);
        mSurfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
    }

    public void setupSurfaceView(){
        mMediaPlayer = new MediaPlayer();
        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mMediaPlayer.setScreenOnWhilePlaying(true);


        // Testing purpose only
        Uri uri = Uri.parse(mVideoData.getVideoPath());
        try {
            mMediaPlayer.setDataSource(mContext, uri);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setIsPlaying(boolean isPlaying) {
        this.isPlaying = isPlaying;
    }

    public VideoData getVideoData() {
        return mVideoData;
    }

    public void setVideoData(VideoData videoData) {
        this.mVideoData = videoData;
    }


    public SurfaceView getSurfaceView() {
        return mSurfaceView;
    }

    public void setSurfaceView(SurfaceView surfaceView) {
        this.mSurfaceView = surfaceView;
    }

    public MediaPlayer getMediaPlayer() {
        return mMediaPlayer;
    }

    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mMediaPlayer = mediaPlayer;
    }

    public SurfaceHolder getSurfaceHolder() {
        return mSurfaceHolder;
    }

    public void setSurfaceHolder(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = surfaceHolder;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        if(mMediaPlayer != null) {
            mMediaPlayer.setDisplay(mSurfaceHolder);
            setSurfaceSize();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        if(mMediaPlayer != null){
            mMediaPlayer.stop();
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (changed && getChildCount() > 0) {
            final View child = getChildAt(0);

            final int width = r - l;
            final int height = b - t;

            int previewWidth = width;
            int previewHeight = height;
            if (mVideoSize != null) {
                previewWidth = mVideoSize.width;
                previewHeight = mVideoSize.height;
            }

            // Center the child SurfaceView within the parent.
            if (width * previewHeight > height * previewWidth) {
                final int scaledChildWidth = previewWidth * height / previewHeight;
                child.layout((width - scaledChildWidth) / 2, 0,
                        (width + scaledChildWidth) / 2, height);
            } else {
                final int scaledChildHeight = previewHeight * width / previewWidth;
                child.layout(0, (height - scaledChildHeight) / 2,
                        width, (height + scaledChildHeight) / 2);
            }
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    private void setSurfaceSize() {
        // get the dimensions of the video (only valid when surfaceView is set)
        float videoWidth = mMediaPlayer.getVideoWidth();
        float videoHeight = mMediaPlayer.getVideoHeight();

        // get the dimensions of the container (the surfaceView's parent in this case)
        View container = (View) mSurfaceView.getParent();
        float containerWidth = container.getWidth();
        float containerHeight = container.getHeight();

        // set dimensions to surfaceView's layout params (maintaining aspect ratio)
        android.view.ViewGroup.LayoutParams lp = mSurfaceView.getLayoutParams();
        lp.width = (int) containerWidth;
        lp.height = (int) ((videoHeight / videoWidth) * containerWidth);
        if(lp.height > containerHeight) {
            lp.width = (int) ((videoWidth / videoHeight) * containerHeight);
            lp.height = (int) containerHeight;
        }
        mSurfaceView.setLayoutParams(lp);
    }
}
