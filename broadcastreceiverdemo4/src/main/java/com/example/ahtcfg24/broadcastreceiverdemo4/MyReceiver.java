package com.example.ahtcfg24.broadcastreceiverdemo4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    private Bundle bundle;

    @Override


    public void onReceive(Context context, Intent intent) {
        String msg = intent.getStringExtra("广播");
        Log.i("FirstReceiver", "--->" + msg);
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
        putBundle(msg);//加工接收到的源广播

    }

    /**
     * 如果下一个Receiver能够接收到这里的bundle，则证明广播确实是从高级别的Receiver传向低级别
     *
     * @param msg 从广播源接收到的消息
     */
    private void putBundle(String msg) {
        bundle = new Bundle();
        bundle.putString("msg1", msg + ",被第一个Receiver处理过了");
        setResultExtras(bundle);
    }
}
