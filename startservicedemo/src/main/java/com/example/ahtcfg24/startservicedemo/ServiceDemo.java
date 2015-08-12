package com.example.ahtcfg24.startservicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class ServiceDemo extends Service
{
    public static final String TAG = "ServiceDemo";

    @Override
    public void onCreate()
    {
        super.onCreate();
        Log.i(TAG, "--->onCreate");
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        Log.i(TAG, "--->onDestroy");


    }

    @Override
    public void onStart(Intent intent, int startId)
    {
        super.onStart(intent, startId);
        Log.i(TAG, "--->onStart");
    }

    /*onBinder()是父类中的抽象方法，必须被复写*/
    @Override
    public IBinder onBind(Intent intent)
    {
        //通过StartService启动无需重写该方法
        return null;
    }
}
