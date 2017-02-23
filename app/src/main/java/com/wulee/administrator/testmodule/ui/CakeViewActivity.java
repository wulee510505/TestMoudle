package com.wulee.administrator.testmodule.ui;

import android.app.Activity;
import android.os.Bundle;

import com.wulee.administrator.testmodule.R;
import com.wulee.administrator.testmodule.entity.BaseMessage;
import com.wulee.administrator.testmodule.view.CakeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wulee on 2016/4/13.
 */
public class CakeViewActivity extends Activity {
    private CakeView mCakeview;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cakeview);

        mCakeview = (CakeView) findViewById(R.id.cakeview);

        List<BaseMessage> list = new ArrayList<BaseMessage>();

        BaseMessage bm = new BaseMessage();
        bm.percent = 25;
        bm.content = "android";
        bm.color = getResources().getColor(R.color.color_light_blue);
        list.add(bm);

        bm = new BaseMessage();
        bm.percent = 10;
        bm.content = "ios";
        bm.color = getResources().getColor(R.color.color_orange);
        list.add(bm);

        bm = new BaseMessage();
        bm.percent = 45;
        bm.content = "php";
        bm.color = getResources().getColor(R.color.colorAccent);
        list.add(bm);

        bm = new BaseMessage();
        bm.percent = 20;
        bm.content = "js";
        bm.color = getResources().getColor(R.color.colorPrimary);
        list.add(bm);

        mCakeview.setCakeData(list);

    }
}
