package com.example.ahtcfg24.startservicedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * 启动Service
 */
public class MainActivity extends Activity {
    private Button button;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);

        button.setOnClickListener(new ButtonListener());
        button2.setOnClickListener(new ButtonListener());
    }


    private class ButtonListener implements OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, ServiceDemo.class);
            switch (v.getId()) {
                case R.id.button:
                    startService(intent);//启动Service
                    break;
                case R.id.button2:
                    stopService(intent);//终止Service
                    break;
                default:
                    break;
            }
        }
    }
}
