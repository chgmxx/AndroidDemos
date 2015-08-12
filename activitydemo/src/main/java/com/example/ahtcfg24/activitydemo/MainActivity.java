package com.example.ahtcfg24.activitydemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * 验证Activity的生命周期
 */
public class MainActivity extends Activity
{

    public static final String TAG = "第一个Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);

        Log.i("第一个Activity", "--->OnCreate");
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
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
    }
}
