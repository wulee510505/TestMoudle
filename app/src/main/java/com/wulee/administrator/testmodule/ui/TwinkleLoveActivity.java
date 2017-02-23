package com.wulee.administrator.testmodule.ui;

import android.app.Activity;
import android.os.Bundle;

import com.wulee.administrator.testmodule.view.TwinkleLoveView;

/**
 * Created by wulee on 2016/4/5.
 */
public class TwinkleLoveActivity extends Activity {

    private TwinkleLoveView love;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.love = new TwinkleLoveView(this);
        setContentView(love);
    }
}
