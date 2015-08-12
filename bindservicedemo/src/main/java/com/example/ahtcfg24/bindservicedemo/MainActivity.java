package com.example.ahtcfg24.bindservicedemo;

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

public class MainActivity extends Activity
{
    public static final String TAG = "ServiceConnect";
    private Button button, button2, button3, button4;
    private ServiceConnection serviceConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);


        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startService(new Intent(MainActivity.this, MyService.class));
            }
        });
        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                stopService(new Intent(MainActivity.this, MyService.class));
            }
        });
        button3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                serviceConnection = new ServiceConnection()
                {
                    @Override
                    public void onServiceConnected(ComponentName name, IBinder service)
                    {
                        Log.i(TAG, "--->onServiceConnected");
                    }

                    @Override
                    public void onServiceDisconnected(ComponentName name)
                    {
                        Log.i(TAG, "--->onServiceDisconnected");

                    }
                };

                bindService(new Intent(MainActivity.this, MyService.class), serviceConnection, Service.BIND_AUTO_CREATE);//第三个参数是指定Service创建类型，一般是BIND_AUTO_CREATE
            }
        });
        button4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                unbindService(serviceConnection);
            }
        });
    }


}
