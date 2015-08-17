package com.example.ahtcfg24.broadcastreceiverdemo4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    private Button button;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send();
            }
        });
    }

    private void send() {
        intent = new Intent("MyOrderBroadcast");//设定广播地址
        intent.putExtra("广播", "这是自定义发出的一条广播");
        sendOrderedBroadcast(intent, "android.permission.RECEIVE_MYBROADCAST");//接收者需要声明权限
    }


}
