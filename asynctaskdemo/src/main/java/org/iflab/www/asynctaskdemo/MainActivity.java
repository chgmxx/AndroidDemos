package org.iflab.www.asynctaskdemo;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private MyAsyncTask myAsyncTask;
    private TextView textView;
    private ProgressBar progressBar;
    private Button startButton, finishButton;
    private String[] characters = new String[]{"加", "载", "完", "成"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAsyncTask.execute(characters);//点击按钮后执行异步任务
            }
        });

        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAsyncTask.cancel(true);//点击按钮后打断正在进行的异步任务
            }
        });
    }

    /**
     * 初始化
     */
    private void init() {
        textView = (TextView) findViewById(R.id.progress_text);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        startButton = (Button) findViewById(R.id.start_button);
        finishButton = (Button) findViewById(R.id.finish_button);
        myAsyncTask=new MyAsyncTask();
    }

    /**
     * 自定义的AsyncTask的子类
     */
    private class MyAsyncTask extends AsyncTask<String, Integer, String> {

        /**
         * 执行异步任务之前在主线程中执行该方法
         */
        @Override
        protected void onPreExecute() {
            textView.setVisibility(View.VISIBLE);
            textView.setText("0%");
        }

        /**
         * 后台线程中执行该异步任务
         *
         * @param params 从execute()中传进来的参数，可以是一组数据也可以是单个数据
         * @return 异步任务执行完毕后返回的结果
         */
        @Override
        protected String doInBackground(String... params) {
            String result = "";
            int progress;
            int count = params.length;
            for (int i = 0; i < count; i++) {
                try {
                    Thread.sleep(1000);//模拟耗时操作，延时一秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                result = result + params[i];
                progress = (int) (((i + 1) / (float) count) * 100);//进度算法
                publishProgress(progress);//更新进度
                if (isCancelled()) {//如果已经点击了取消，就跳出循环
                    break;
                }
            }
            return result;
        }

        /**
         * doInBackground方法执行完毕后在主线程中执行该方法
         *
         * @param result doInBackground()返回的结果
         */
        @Override
        protected void onPostExecute(String result) {
            textView.setText(result);
        }

        /**
         * 当publishProgress方法被执行后立即在主线程中执行该方法
         *
         * @param values publishProgress方法传进来的参数，一般为进度信息
         */
        @Override
        protected void onProgressUpdate(Integer... values) {
            for (int progress : values) {
                progressBar.setProgress(progress);
                textView.setText(progress + "%");
            }
        }

        /**
         * 如果执行了cancel()方法，那么在执行完doInBackground后就会在主线程中执行该方法，
         * 而不会去执行onPostExecute
         *
         * @param result 从doInBackground中返回的result
         */
        @Override
        protected void onCancelled(String result) {
            Toast.makeText(getApplicationContext(), "result：" + result, Toast.LENGTH_SHORT).show();
        }
    }
}
