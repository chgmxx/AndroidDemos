package com.example.ahtcfg24.broadcastreceiverdemo4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver3 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String msg = getResultExtras(true).getString("msg2");
        Log.i("ThirdReceiver", "--->" + msg);
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();

    }

}
