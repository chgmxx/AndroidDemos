package com.example.ahtcfg24.bindservicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service
{
    public static final String TAG = "MyService";


    @Override
    public IBinder onBind(Intent intent)
    {
        Log.i(TAG, "--->onBind");
        return null;
    }

    @Override
    public void onCreate()
    {
        Log.i(TAG, "--->onCreate");

        super.onCreate();
    }

    @Override
    public void onDestroy()
    {
        Log.i(TAG, "--->onDestroy");

        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent)
    {
        Log.i(TAG, "--->onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onStart(Intent intent, int startId)
    {
        Log.i(TAG, "--->onStart");
        super.onStart(intent, startId);
    }
}
