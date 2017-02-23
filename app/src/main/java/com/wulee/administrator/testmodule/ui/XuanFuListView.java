package com.wulee.administrator.testmodule.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.wulee.administrator.testmodule.R;

/**
 * Created by Administrator on 2016/6/24.
 */

public class XuanFuListView extends Activity{

    private  LinearLayout invis;
    private  ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sticky);
        invis = (LinearLayout) findViewById(R.id.invis);

        String[] strs = new String[30];

        for (int i = 0; i < 30; i++) {
            strs[i] = "data-----" + i;
        }

        lv = (ListView) findViewById(R.id.lv);
        View header = View.inflate(this, R.layout.stick_header, null);//头部内容
        lv.addHeaderView(header);//添加头部
        lv.addHeaderView(View.inflate(this, R.layout.stick_action, null));//ListView条目中的悬浮部分 添加到头部

        lv.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, strs));
        lv.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
            }
            @Override
            public void onScroll(AbsListView view, int firstVisibleItem,int visibleItemCount, int totalItemCount) {
                if (firstVisibleItem >= 1) {
                    invis.setVisibility(View.VISIBLE);
                } else {
                    invis.setVisibility(View.GONE);
                }
            }
        });
    }



}
