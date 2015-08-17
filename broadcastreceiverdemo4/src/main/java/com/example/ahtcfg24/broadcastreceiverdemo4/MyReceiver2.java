package com.example.ahtcfg24.broadcastreceiverdemo4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver2 extends BroadcastReceiver {
    private Bundle bundle;

    @Override
    public void onReceive(Context context, Intent intent) {
        String msg = getResultExtras(true).getString("msg1");
        Log.i("SecondReceiver", "--->" + msg);
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();

        putBundle(msg);

        abortBroadcast();//停止广播

    }

    private void putBundle(String msg) {
        bundle = new Bundle();
        bundle.putString("msg2", msg + ",被第二个Receiver处理过了");
        setResultExtras(bundle);
    }
}
