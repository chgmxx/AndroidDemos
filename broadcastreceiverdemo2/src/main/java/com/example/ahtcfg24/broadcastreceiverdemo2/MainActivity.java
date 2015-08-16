package com.example.ahtcfg24.broadcastreceiverdemo2;

import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private MyReceiver receiver;
    private IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerMyReceiver();
    }

    /**
     * 在代码中动态注册receiver
     */
    public void registerMyReceiver() {
        receiver = new MyReceiver();
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
        registerReceiver(receiver, intentFilter);
    }

    /**
     * 当退出程序时如果没有注销Receiver，就会出现异常，因此在onDestroy中进行注销操作
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}
