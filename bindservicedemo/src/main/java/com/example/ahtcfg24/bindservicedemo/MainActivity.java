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
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);


        button.setOnClickListener(new ButtonListener());
        button2.setOnClickListener(new ButtonListener());
        button3.setOnClickListener(new ButtonListener());
        button4.setOnClickListener(new ButtonListener());

    }

    /**
     * 如果在service绑定的Activity被结束之后，service却没有解绑就会导致后台出现异常
     * 或者在连接中断后去解绑也会出现异常
     * 这样做可保障不出现上述异常
     */
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        unbindService(serviceConnection);
    }

    private class ButtonListener implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            intent = new Intent(MainActivity.this, MyService.class);
            switch (v.getId())
            {
                case R.id.button:
                    startService(intent);
                    break;
                case R.id.button2:
                    stopService(intent);
                    break;
                case R.id.button3:
                    serviceConnection = new ServiceConnection()
                    {
                        /**
                         * 该方法只在onBind方法有不为空的返回值时才会被调用
                         *
                         * @param name    与当前组件（Activity）绑定的Service名称
                         * @param service 从绑定的Service中的onBind方法中返回的IBender实例
                         */
                        @Override
                        public void onServiceConnected(ComponentName name, IBinder service) {
                            System.out.println(name);
                            System.out.println(service);
                            Log.i(TAG, "--->onServiceConnected");
                        }

                        @Override
                        public void onServiceDisconnected(ComponentName name)
                        {
                            Log.i(TAG, "--->onServiceDisconnected");
                        }
                    };
                    bindService(intent, serviceConnection, Service.BIND_AUTO_CREATE);
                    //第三个参数是指定Service创建类型，一般是BIND_AUTO_CREATE
                    break;
                case R.id.button4:
                    unbindService(serviceConnection);
                    break;
                default:
                    break;
            }
        }
    }
}
