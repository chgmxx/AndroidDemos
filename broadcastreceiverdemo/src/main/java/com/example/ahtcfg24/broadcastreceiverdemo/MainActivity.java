package com.example.ahtcfg24.broadcastreceiverdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {
    private Button button;

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

    public void send() {
        Intent intent = new Intent("android.intent.action.My_Broadcast");
        intent.putExtra("广播", "这是自定义发出的一条广播");
        sendBroadcast(intent);
    }

}
