package com.wulee.administrator.testmodule.ui;

import android.app.Activity;
import android.os.Bundle;

import com.wulee.administrator.testmodule.R;
import com.wulee.administrator.testmodule.view.radarview.RadarView;
import com.wulee.administrator.testmodule.view.radarview.WaterRadarView;

/**
 * Created by wulee on 2016/9/26 16:03
 */

public class RadarViewActivity extends Activity {
    private RadarView mRadarView;
    private WaterRadarView mWaterRadarView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radarview_layout);

        mRadarView = (RadarView) findViewById(R.id.radarview);
        mWaterRadarView = (WaterRadarView) findViewById(R.id.waterradarview);

        mRadarView.start();
        mRadarView.setmImageUrl("http://p5.qhimg.com/t01ba4f7909f15de5fc.jpg");

        mWaterRadarView.start();
        mWaterRadarView.setmImageUrl("http://p5.qhimg.com/t01ba4f7909f15de5fc.jpg");
    }
}