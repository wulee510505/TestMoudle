package com.wulee.administrator.testmodule.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.wulee.administrator.testmodule.R;
import com.wulee.administrator.testmodule.view.PowerImageView;

/**
 * Created by wulee on 2016/4/13.
 */
public class PowerImageViewActivity extends Activity {
    private PowerImageView mPowerImageView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.power_imageview);

        mPowerImageView  = (PowerImageView) findViewById(R.id.image_view);
        mPowerImageView.setLayerType(View.LAYER_TYPE_SOFTWARE, null); //view级关闭硬件加速
    }
}
