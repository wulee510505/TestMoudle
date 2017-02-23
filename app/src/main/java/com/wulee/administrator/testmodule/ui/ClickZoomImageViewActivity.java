package com.wulee.administrator.testmodule.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.wulee.administrator.testmodule.R;
import com.wulee.administrator.testmodule.view.ImageZoom;

/**
 * Created by wulee on 2016/4/13.
 */
public class ClickZoomImageViewActivity extends AppCompatActivity {
    private ImageZoom mImageZoom;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.click_zoom_button);

        mImageZoom = (ImageZoom) findViewById(R.id.zoomImageview);
        mImageZoom.setImageResource(R.drawable.icon);
    }

}
