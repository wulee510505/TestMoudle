package com.wulee.administrator.testmodule.ui;

import android.os.Bundle;

import com.wulee.administrator.testmodule.R;
import com.wulee.administrator.testmodule.view.WalkthroughItem;

/**
 * Created by wulee on 2016/5/18.
 */
public class GuidePageActivity extends WalkthroughActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        WalkthroughItem page1 = new WalkthroughItem(R.mipmap.ic_launcher, "第一页标题", "第一页子标题");
        page1.setTitleColorID(android.R.color.holo_blue_dark)
                .setSubTitleColorID(android.R.color.holo_blue_bright)
                .setSkipColorID(R.color.blue);

        WalkthroughItem page2 = new WalkthroughItem(R.mipmap.ic_launcher,"第二页标题", "第二页子标题");
        page2.setBackgroundColorID(R.color.navy)
                .setTitleColorID(android.R.color.holo_red_light)
                .setSubTitleColorID(android.R.color.holo_red_dark)
                .setSkipColorID(android.R.color.white);

        WalkthroughItem page3 = new WalkthroughItem(R.mipmap.ic_launcher, "第三页标题","第三页子标题");
        page3.setBackgroundColorID(R.color.calypso)
                .setTitleColorID(android.R.color.holo_blue_light)
                .setSubTitleColorID(R.color.calypso);

        addPage(page1);
        addPage(page2);
        addPage(page3);

        setProgressType(DOTS_TYPE);
        setTransitionType(ZOOM_OUT_SLIDE_TRANSFORMER);
        setNextButtonColor(R.color.navy);
        setProgressBarColor(R.color.breaker_bay);
    }

    @Override
    public void onFinish() {
        finish();
    }
}
