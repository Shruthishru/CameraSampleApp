package com.compassites.kotlin.camera;

import android.content.Context;
import android.hardware.Camera;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

/**
 * Created by shruthi on 27/3/18.
 */

public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {

    private Camera mcamera;
    private SurfaceHolder holder;
    public CameraPreview(Context context,Camera camera) {
        super(context);
        mcamera = camera;
        holder = getHolder();
        holder.addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        try {
            mcamera.setPreviewDisplay(surfaceHolder);
            mcamera.startPreview();
        } catch (IOException e) {
            Log.d(MainActivity.class.getSimpleName(),"error");
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {
        mcamera.stopPreview();
        try {
            mcamera.setPreviewDisplay(holder);
            mcamera.startPreview();
        } catch (IOException e) {
            Log.d(MainActivity.class.getSimpleName(),"error");
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }
}
