package com.example.camera;

import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.TextureView;

import com.example.camera.config.AppConfigKt;
import com.troila.ai.FaceRecognition;

import static android.hardware.Camera.CameraInfo.CAMERA_FACING_FRONT;

public class MainActivity extends AppCompatActivity implements TextureView.SurfaceTextureListener {
    private TextureView mSurfaceView;
    private Camera mCamera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSurfaceView = findViewById(R.id.surface_camera);
        mSurfaceView.setSurfaceTextureListener(this);
    }

    //初始化Camera
    private void initCamera(SurfaceTexture surfaceTexture) {
        mCamera = Camera.open(CAMERA_FACING_FRONT);
        Camera.Parameters parameters = mCamera.getParameters();
        parameters.setPreviewFormat(ImageFormat.NV21);

        //这是摄像头宽、高
        int width = mCamera.getParameters().getPreviewSize().width;
        int height = mCamera.getParameters().getPreviewSize().height;
        parameters.setPreviewSize(width, height);

        mCamera.setParameters(parameters);

    }
    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {

    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {

    }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        return false;
    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {

    }
}
