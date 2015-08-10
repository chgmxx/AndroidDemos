package com.example.ahtcfg24.handlerprogressbardemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;


public class MainActivity extends Activity {
    private Button button;
    private ProgressBar progressBar;
    private Runnable task;
    private MyHandler handler;
    private Message msg;
    private int progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new buttonListener());
        handler = new MyHandler();
        task = new Runnable() {
            @Override
            public void run() {
                System.out.println("这个线程在运行");
                progress = progress + 10;
                msg = handler.obtainMessage();
                msg.arg1 = progress;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handler.sendMessage(msg);//task线程发送完消息之后，消息msg进入消息队列，handleMessage启动

            }
        };
    }

    class buttonListener implements OnClickListener {

        @Override
        public void onClick(View v) {
            progressBar.setVisibility(View.VISIBLE);
            handler.post(task);//post之后task进入队列，task线程立即执行，主线程不再参与
        }
    }

    class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            System.out.println("handler在运行");
            super.handleMessage(msg);
            progressBar.setProgress(msg.arg1);//使用msg.arg1来传递消息而不是用progress直接传递是为了提高性能
            if (msg.arg1 > 100) {
                handler.removeCallbacks(task);
                progressBar.setVisibility(View.GONE);
            } else {
                handler.post(task);
            }
        }
    }
}
