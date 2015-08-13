package com.example.ahtcfg24.bindservicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service
{
    public static final String TAG = "MyService";

    /**
     * @param intent
     * @return bind service时需要使得onBind方法返回一个IBinder类型的类，而Binder类恰好实现了IBinder接口
     */
    @Override
    public IBinder onBind(Intent intent)
    {
        Log.i(TAG, "--->onBind");
        return new Binder()
        {
            public Service getService()
            {
                return MyService.this;
            }
        };

    }

    @Override
    public void onCreate()
    {
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
