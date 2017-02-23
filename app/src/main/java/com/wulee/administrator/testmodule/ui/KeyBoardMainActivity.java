package com.wulee.administrator.testmodule.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.wulee.administrator.testmodule.R;
import com.wulee.administrator.testmodule.ui.keyboard.RandomActivity;
import com.wulee.administrator.testmodule.ui.keyboard.XianYuActivity;

/**
 * Created by wulee on 2016/9/28 11:11
 */

public class KeyBoardMainActivity extends AppCompatActivity implements OnClickListener{


    private Button btnRondom;
    private Button btnXianyu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard_main);

        btnRondom = (Button) findViewById(R.id.btn_rondom);
        btnXianyu = (Button) findViewById(R.id.btn_xianyu);

        btnRondom.setOnClickListener(this);
        btnXianyu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_rondom:
                startActivity(new Intent(this, RandomActivity.class));
                break;
            case R.id.btn_xianyu:
                startActivity(new Intent(this, XianYuActivity.class));
                break;
        }
    }
}