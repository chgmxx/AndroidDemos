package com.example.ahtcfg24.serviceplayerdemo;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import static android.view.View.OnClickListener;

public class MainActivity extends Activity
{
    public static final String TAG = "Connected";
    private Button button, button2;
    private Intent intent;
    private MyService.MyBinder myService;
    private ServiceConnection connection;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);

        button.setOnClickListener(new ButtonListener());
        button2.setOnClickListener(new ButtonListener());

        intent = new Intent(MainActivity.this, MyService.class);
        connection = new ServiceConnection()
        {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service)
            {
                Log.i(TAG, "--->音乐服务已连接");
                myService = (MyService.MyBinder) service;
                myService.playMedia();//播放
            }

            @Override
            public void onServiceDisconnected(ComponentName name)
            {
                Log.i(TAG, "--->音乐服务已崩溃");
            }
        };
    }


    private class ButtonListener implements OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            switch (v.getId())
            {
                case R.id.button:
                    bindService(intent, connection, Service.BIND_AUTO_CREATE);
                    break;
                case R.id.button2:
                    startService(intent);
                    break;
                default:
                    break;
            }
        }
    }
}
