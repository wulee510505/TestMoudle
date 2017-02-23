package com.wulee.administrator.testmodule.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.wulee.administrator.testmodule.view.ClockView;

/**
 * Created by wulee on 2016/4/13.
 */
public class ClockViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new ClockView(this));
    }
}
