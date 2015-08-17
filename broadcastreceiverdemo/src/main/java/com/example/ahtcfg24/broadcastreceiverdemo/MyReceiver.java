package com.example.ahtcfg24.broadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * 由于清单文件中的Receiver注册的广播地址是android.intent.action.AIRPLANE_MODE，
 * 因此当手机被调成飞行模式，或者从飞行模式恢复正常模式时，都会执行onReceive方法
 */
public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String msg = intent.getStringExtra("广播");
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
        Log.i("静态广播", "--->" + msg);
    }
}
