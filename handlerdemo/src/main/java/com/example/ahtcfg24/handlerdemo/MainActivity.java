package com.example.ahtcfg24.handlerdemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity {
    private Button button1;
    private Button button2;
    private Handler handler;
    private Runnable task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button_start);
        button1.setOnClickListener(new startListener());
        button2 = (Button) findViewById(R.id.button_end);
        button2.setOnClickListener(new endListener());

        handler = new Handler();
        task = new Runnable() {
            @Override
            public void run() {
                System.out.println("这个线程在运行");

                Toast.makeText(MainActivity.this, "哈哈", Toast.LENGTH_SHORT).show();
                handler.postDelayed(task, 5000);//task再次进入队列，五秒后再次被执行
            }
        };
    }


    class startListener implements OnClickListener {

        @Override
        public void onClick(View v) {

            handler.post(task);//task第一次进入队列，task立即被执行，主线程不再参与
        }


    }

    class endListener implements OnClickListener {

        @Override
        public void onClick(View v) {
            handler.removeCallbacks(task);
            Toast.makeText(MainActivity.this, "停止", Toast.LENGTH_SHORT).show();
        }
    }
}
