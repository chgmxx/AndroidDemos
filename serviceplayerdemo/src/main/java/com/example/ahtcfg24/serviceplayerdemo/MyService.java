package com.example.ahtcfg24.serviceplayerdemo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service
{
    public static final String TAG = "MyService";
    private MediaPlayer player;

    @Override
    public IBinder onBind(Intent intent)
    {

        Log.i(TAG, "--->onBind");
        return new MyBinder();
    }

    @Override
    public void onCreate()
    {
        player = MediaPlayer.create(getApplicationContext(), R.raw.music);
        player.setLooping(true);//设置可循环播放
        Log.i(TAG, "--->onCreate");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        Log.i(TAG, "--->onStartCommand");

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy()
    {
        Log.i(TAG, "--->onDestroy");
        super.onDestroy();
        player.stop();//Service结束时就停止播放
    }

    @Override
    public boolean onUnbind(Intent intent)
    {
        Log.i(TAG, "--->onUnbind");

        return super.onUnbind(intent);
    }

    class MyBinder extends Binder
    {
        public void playMedia()
        {
            player.start();//播放
        }
    }
}
