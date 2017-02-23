package com.wulee.administrator.testmodule.ui;

import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.wulee.administrator.testmodule.R;
import com.wulee.administrator.testmodule.adapter.AdItemViewAdapter;
import com.wulee.administrator.testmodule.entity.AdverNotice;
import com.wulee.administrator.testmodule.view.CircleImageView;
import com.wulee.administrator.testmodule.view.AdverItemView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wulee on 2016/4/13.
 */
public class CircleImageViewActivity extends AppCompatActivity {

    private CircleImageView mCircleImageView;

    private AdverItemView mAdverItemView;
    private List<AdverNotice> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.circle_imageview);

        mCircleImageView = (CircleImageView) findViewById(R.id.circleimageview);

        ColorFilter colorFilter = new LightingColorFilter(Color.RED,Color.GREEN);
        //mCircleImageView.setColorFilter(colorFilter);
        mCircleImageView.setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);


        initData();
        AdItemViewAdapter adapter = new AdItemViewAdapter(mDatas);
        mAdverItemView = (AdverItemView) findViewById(R.id.jd_adverview);
        mAdverItemView.setAdapter(adapter);
        //开启线程滚东
        mAdverItemView.start();
    }

    private void initData() {
        mDatas = new ArrayList<AdverNotice>();

        mDatas.add(new AdverNotice("瑞士维氏军刀 新品满200-50","最新"));
        mDatas.add(new AdverNotice("家居家装焕新季，讲199减100！","最火爆"));
        mDatas.add(new AdverNotice("带上相机去春游，尼康低至477","HOT"));
        mDatas.add(new AdverNotice("价格惊呆！电信千兆光纤上市","new"));
    }
}
