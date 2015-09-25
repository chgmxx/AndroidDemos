package com.example.ahtcfg24.listviewdemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private ListView listView;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initListView();

    }

    private void initListView() {
        listView = (ListView) findViewById(R.id.listView);
        list = new ArrayList<>();
        list.add("item0");
        list.add("item1");
        list.add("item2");
        list.add("item3");
        list.add("item4");
        list.add("item5");
        list.add("item6");
        list.add("item7");
        list.add("item8");
        list.add("item9");
        list.add("item10");
        list.add("item11");
        list.add("item12");
        listView.setAdapter(new MyListAdapter(this, list));

    }


    private class MyListAdapter extends BaseAdapter {
        private Context context;
        private List<String> list;

        public MyListAdapter(Context context, List<String> list) {
            this.context = context;
            this.list = list;
        }

        /**
         * @return 要绘制的View数目，不能大于实际存在资源总数
         */
        @Override
        public int getCount() {
            return list.size();
        }

        /**
         * 覆盖自AdapterView，此处不会自动调用
         */
        @Override
        public Object getItem(int position) {
            return null;
        }

        /**
         * 点击时调用
         */
        @Override
        public long getItemId(int position) {
            return 0;
        }

        /**
         * 通过传入的position，把需要绘制的View数据加工成我们想要的View，最后返回给父级容器使用
         * 把数据和控件联系起来的关键方法，形成一个缓冲模型，屏幕上能显示的View都在内存里，
         * 而把不能显示的放进缓冲区队列Recycle里，缓冲区占用总大小是一个屏幕能显示的所有View数量+2再整体
         * 乘单个View所占的内存空间
         *
         * @param position    即将脱离屏幕边缘的位置，如果屏幕向上滑动就是最上端的View所在位置
         * @param convertView 即将出缓冲区再度进入内存被重新利用的View，在屏幕未被占满时，该参数为空,
         *                    此时可以为其新建一个View对象，也可以从XML布局文件中inflate出来一个View对象，
         *                    当屏幕被占满，有View进入缓冲区时，这时该参数就是一个已经存在过但已经脱离屏幕
         *                    范围时的View对象
         * @param parent      item的父级容器，一般都为空
         * @return 要显示的每个item的View
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);
                viewHolder = new ViewHolder();
                viewHolder.textView = (TextView) convertView.findViewById(R.id.textView);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.textView.setText(list.get(position));
            return convertView;
        }
    }

    public class ViewHolder {
        private TextView textView;
    }
}
