package com.example.edgedetect;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends Activity {
    private TextureView textureView;
    static {
        System.loadLibrary("edgedetect");
    }

    private native void nativeInit(int width, int height);
    private native void nativeProcessFrame(byte[] input, int len, int width, int height);
    private native void nativeToggleMode(int mode);

    public static final int REQUEST_CAMERA = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textureView = new TextureView(this);
        setContentView(textureView);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, REQUEST_CAMERA);
        } else {
            startCamera();
        }

        textureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() {
            @Override
            public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
                nativeInit(width, height);
                // In a full implementation, start Camera2 and forward frames to nativeProcessFrame
            }

            @Override
            public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {}

            @Override
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) { return true; }

            @Override
            public void onSurfaceTextureUpdated(SurfaceTexture surface) {}
        });

        Button btn = new Button(this);
        btn.setText("Toggle Mode");
        btn.setVisibility(View.GONE);
        btn.setOnClickListener(v -> nativeToggleMode(1));
        addContentView(btn, new android.view.ViewGroup.LayoutParams(1,1));
    }

    private void startCamera() {
        // Camera setup omitted for brevity - use Camera2 API in real implementation
    }
}
