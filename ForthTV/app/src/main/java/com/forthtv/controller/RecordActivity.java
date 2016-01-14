package com.forthtv.controller;

import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.forthtv.BaseActivity;
import com.forthtv.R;
import com.forthtv.util.camera.CameraUtil;
import com.forthtv.util.camera.SurfacePreview;

import java.io.IOException;

/**
 * Created by cuongvo on 1/12/16.
 */
public class RecordActivity extends BaseActivity implements Camera.PreviewCallback{

    private boolean isCameraFront = false;
    private boolean isRecording = false;

    private Camera mCamera;
    private Camera.CameraInfo mCameraInfo;
    private MediaRecorder mMediaRecorder;
    private SurfaceView mSurface;
    private SurfacePreview mSurfacePreview;
    private RelativeLayout mRelativeLayoutMediaOptions;

    public RecordActivity(){
        mActivityType = ActivityType.ACTIVITY_RECORD;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        mSurface = (SurfaceView)findViewById(R.id.activity_record_surface);
        mSurfacePreview = new SurfacePreview(this, mSurface);
        mSurfacePreview.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        mRelativeLayoutMediaOptions = (RelativeLayout)findViewById(R.id.activity_record_media_options);
        FrameLayout record = (FrameLayout)mRelativeLayoutMediaOptions.findViewById(R.id.view_record_record_layout);
        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isRecording) {
                    // stop recording and release camera
                    mMediaRecorder.stop(); // stop the recording
                    releaseMediaRecorder(); // release the MediaRecorder object
                    Toast.makeText(RecordActivity.this, "Video captured!", Toast.LENGTH_LONG).show();
                    isRecording = false;
                } else {
                    if (!prepareMediaRecorder()) {
                        Toast.makeText(RecordActivity.this, "Fail in prepareMediaRecorder()!\n - Ended -", Toast.LENGTH_LONG).show();
                        finish();
                    }

                    // work on UiThread for better performance
                    runOnUiThread(new Runnable() {
                        public void run() {
                            // If there are stories, add them to the table
                            try {
                                mMediaRecorder.start();
                            } catch (final Exception ex) {
                                // Log.i("---","Exception in thread");
                            }
                        }
                    });

                    isRecording = true;
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (!CameraUtil.hasCamera(this)) {
            Toast toast = Toast.makeText(this, "Sorry, your phone does not have a camera!", Toast.LENGTH_LONG);
            toast.show();
            finish();
        }

        if (mCamera == null) {
            // if the front facing camera does not exist
            if (CameraUtil.findBackFacingCamera()) {
                // release the old camera instance
                // switch camera, from the front and the back and vice versa
                releaseCamera();
                chooseCamera();
            } else {
                Toast toast = Toast.makeText(this, "Sorry, your phone has only one camera!", Toast.LENGTH_LONG);
                toast.show();
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSurfacePreview.setCamera(null);
        releaseCamera();
    }

    public void chooseCamera() {
        // if the camera preview is the front
        if (isCameraFront) {
            int cameraId = CameraUtil.findCameraId();
            if (cameraId >= 0) {
                // open the backFacingCamera
                // set a picture callback
                // refresh the preview
                mCamera = Camera.open(cameraId);
                mCamera.setPreviewCallback(this);
                CameraUtil.setCameraDisplayOrientation(this, cameraId, mCamera);
                mSurfacePreview.setCamera(mCamera);
            }
        } else {
            int cameraId = CameraUtil.findCameraId();
            if (cameraId >= 0) {
                // open the backFacingCamera
                // set a picture callback
                // refresh the preview
                mCamera = Camera.open(cameraId);
                CameraUtil.setCameraDisplayOrientation(this, cameraId, mCamera);
                mCamera.setPreviewCallback(this);
                mSurfacePreview.setCamera(mCamera);
            }
        }
    }

    private boolean prepareMediaRecorder() {
        mMediaRecorder = new MediaRecorder();
        mCamera.unlock();
        mMediaRecorder.setCamera(mCamera);
        mMediaRecorder.setAudioSource(MediaRecorder.AudioSource.CAMCORDER);
        mMediaRecorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);

        if (CamcorderProfile.hasProfile(CameraUtil.findCameraId(), CamcorderProfile.QUALITY_720P)) {
            mMediaRecorder.setProfile(CamcorderProfile.get(CamcorderProfile.QUALITY_720P));
        } else {
            mMediaRecorder.setProfile(CamcorderProfile.get(CamcorderProfile.QUALITY_LOW));
        }

        mMediaRecorder.setOutputFile("/sdcard/myvideo.mp4");
        mMediaRecorder.setMaxDuration(600000); //set maximum duration 60 sec.
        mMediaRecorder.setMaxFileSize(50000000); //set maximum file size 50M

        try {
            mMediaRecorder.prepare();
        } catch (IllegalStateException e) {
            releaseMediaRecorder();
            return false;
        } catch (IOException e) {
            releaseMediaRecorder();
            return false;
        }
        return true;

    }

    private void releaseCamera() {
        if (mCamera != null) {
            mCamera.release();
            mCamera = null;
        }
    }

    private void releaseMediaRecorder() {
        if (mMediaRecorder != null) {
            mMediaRecorder.reset(); // clear recorder configuration
            mMediaRecorder.release(); // release the recorder object
            mMediaRecorder = null;
            mCamera.lock(); // lock camera for later use
        }
    }

    @Override
    public void onPreviewFrame(byte[] data, Camera camera) {

    }
}
