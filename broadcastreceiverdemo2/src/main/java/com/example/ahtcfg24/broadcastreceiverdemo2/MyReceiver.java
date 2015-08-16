package com.example.ahtcfg24.broadcastreceiverdemo2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "收到广播", Toast.LENGTH_LONG).show();
        Log.i("动态注册", "--->收到广播");
    }
}
