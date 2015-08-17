package com.example.ahtcfg24.broadcastreceiverdemo3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver2 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("2", "--->Received");
        abortBroadcast();//终止广播的发送
    }
}
