package com.example.ahtcfg24.activitydemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends Activity
{

    public static final String TAG = "第二个Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });

    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        Log.i(TAG, "--->OnRestart");
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Log.i(TAG, "--->OnStart");
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Log.i(TAG, "--->OnResume");
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        Log.i(TAG, "--->OnPause");
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Log.i(TAG, "--->OnStop");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.i(TAG, "--->OnDestroy");
        Toast.makeText(Main2Activity.this, "结束啦", Toast.LENGTH_SHORT).show();
    }
}