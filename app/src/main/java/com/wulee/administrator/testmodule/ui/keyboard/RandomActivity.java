package com.wulee.administrator.testmodule.ui.keyboard;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.wulee.administrator.testmodule.R;
import com.wulee.administrator.testmodule.utils.KeyboardUtil;
import com.wulee.administrator.testmodule.view.MyKeyBoardView;

/**
 * Created by xuejinwei on 16/8/19.
 * Email:xuejinwei@outlook.com
 */
public class RandomActivity extends AppCompatActivity {


    private EditText etRondom;
    MyKeyBoardView keyboardView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);

        etRondom = (EditText) findViewById(R.id.et_rondom);
        final KeyboardUtil keyboardUtil = new KeyboardUtil(RandomActivity.this, true);

        etRondom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyboardUtil.attachTo(etRondom);
            }
        });
    }
}
