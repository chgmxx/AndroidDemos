package com.example.ahtcfg24.demo;

import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.LinearLayout;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VideoDemoActivity extends AppCompatActivity {
    @BindView(R.id.surfaceView)
    SurfaceView surfaceView;
    private int postion = 0;

    private String videoUrl = "http://10.1.14.30/mp4files/3247000000E220B5/45.32.248.32/openedx_demo/EDXSPCPJSP13-H010000_100.mp4";
    private MediaPlayer mediaPlayer;
    private SurfaceHolder holder;
    private Point screenSize = new Point();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_demo);
        ButterKnife.bind(this);
        getWindowManager().getDefaultDisplay().getSize(screenSize);

        mediaPlayer = new MediaPlayer();
        holder = surfaceView.getHolder();

        try {
            mediaPlayer.setDataSource(videoUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }

        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                // 当prepare完成后，该方法触发，在这里我们播放视频

                //首先取得video的宽和高
                int videoWidth = mediaPlayer.getVideoWidth();
                int videoHeight = mediaPlayer.getVideoHeight();

                if (videoWidth > screenSize.x || videoHeight > screenSize.y) {
                    //如果video的宽或者高超出了当前屏幕的大小，则要进行缩放
                    float wRatio = (float) videoWidth / (float) screenSize.x;
                    float hRatio = (float) videoHeight / (float) screenSize.y;

                    //选择大的一个进行缩放
                    float ratio = Math.max(wRatio, hRatio);

                    videoWidth = (int) Math.ceil((float) videoWidth / ratio);
                    videoHeight = (int) Math.ceil((float) videoHeight / ratio);

                    //设置surfaceView的布局参数
                    surfaceView.setLayoutParams(new LinearLayout.LayoutParams(videoWidth, videoHeight));

                    //然后开始播放视频

                    mediaPlayer.start();
                }
            }
        });

        holder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                mediaPlayer.setDisplay(holder);
                mediaPlayer.prepareAsync();

            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });
    }


    @Override
    protected void onPause() {
        if (mediaPlayer.isPlaying()) {
            // 保存当前播放的位置
            postion = mediaPlayer.getCurrentPosition();
            mediaPlayer.stop();
        }
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
        mediaPlayer.release();
        super.onDestroy();
    }

}
