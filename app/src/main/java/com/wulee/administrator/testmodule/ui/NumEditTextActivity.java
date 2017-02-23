package com.wulee.administrator.testmodule.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.wulee.administrator.testmodule.R;
import com.wulee.administrator.testmodule.view.AnFQNumEditText;

/**
 * Created by wulee on 2016/10/12 17:28
 */

public class NumEditTextActivity extends AppCompatActivity implements TextView.OnEditorActionListener {

    private AnFQNumEditText anetDemo;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_num_edittext);

        anetDemo = (AnFQNumEditText) findViewById(R.id.anetDemo);
        editText = (EditText) findViewById(R.id.edittext);
        editText.setOnEditorActionListener(this);

        anetDemo.setEtHint("内容")//设置提示文字
                .setEtMinHeight(200)//设置最小高度，单位px
                .setLength(100)//设置总字数
                .setType(AnFQNumEditText.SINGULAR)//TextView显示类型(SINGULAR单数类型)(PERCENTAGE百分比类型)
                .setLineColor("#cdcdcd")//设置横线颜色
                .show();
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        switch(actionId){
            case EditorInfo.IME_ACTION_SEARCH:
                Toast.makeText(NumEditTextActivity.this,"actoin search for: " + v.getText(),Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
