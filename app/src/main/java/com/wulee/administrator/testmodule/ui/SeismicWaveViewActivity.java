package com.wulee.administrator.testmodule.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wulee.administrator.testmodule.R;
import com.wulee.administrator.testmodule.view.SeismicWaveView;

/**
 * Created by will wu on 2016/10/20.
 *
 * @deprecated 地震波
 */

public class SeismicWaveViewActivity extends Activity {
    private Button btn;
    private SeismicWaveView seismicWaveView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seismic_wave_view_activity);
        initView();
        initData();
        initLisener();
    }

    private void initView() {
        btn = (Button) findViewById(R.id.button);
        seismicWaveView = (SeismicWaveView) findViewById(R.id.seismicwaveview);
    }

    private void initData() {
        btn.setText("开始");
    }

    private void initLisener() {
        //控制地震波的按钮
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (seismicWaveView.isStarting()) {
                    btn.setText("继续");
                    seismicWaveView.stop();
                } else {
                    btn.setText("停止");
                    seismicWaveView.start();
                }
            }
        });
    }
}
