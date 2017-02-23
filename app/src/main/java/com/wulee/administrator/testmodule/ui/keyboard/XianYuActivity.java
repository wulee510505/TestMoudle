package com.wulee.administrator.testmodule.ui.keyboard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.wulee.administrator.testmodule.R;
import com.wulee.administrator.testmodule.utils.KeyboardUtil;
import com.wulee.administrator.testmodule.view.MyKeyBoardView;

import butterknife.ButterKnife;

/**
 * Created by xuejinwei on 16/8/19.
 * Email:xuejinwei@outlook.com
 */
public class XianYuActivity extends AppCompatActivity {


    private TextView tv_price;
    private LinearLayout ll_price;
    private EditText et_price;
    private EditText et_orginal_price;
    private EditText et_freight;
    private MyKeyBoardView keyboardView;
    private LinearLayout ll_price_select;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xianyu);
        ButterKnife.bind(this);

        tv_price = (TextView) findViewById(R.id.tv_price);
        ll_price = (LinearLayout) findViewById(R.id.ll_price);
        et_price = (EditText) findViewById(R.id.et_price);
        et_orginal_price = (EditText) findViewById(R.id.et_orginal_price);
        et_freight = (EditText) findViewById(R.id.et_freight);
        ll_price_select = (LinearLayout) findViewById(R.id.ll_price_select);

        final KeyboardUtil keyboardUtil = new KeyboardUtil(XianYuActivity.this);
        keyboardUtil.setOnOkClick(new KeyboardUtil.OnOkClick() {
            @Override
            public void onOkClick() {
                if (validate()) {
                    ll_price_select.setVisibility(View.GONE);
                    tv_price.setText(et_price.getText() + "/价格，" + et_orginal_price.getText() + "/原价，" + et_freight.getText() + "/运费");
                }
            }
        });

        keyboardUtil.setOnCancelClick(new KeyboardUtil.onCancelClick() {
            @Override
            public void onCancellClick() {
                ll_price_select.setVisibility(View.GONE);
            }
        });

        ll_price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyboardUtil.attachTo(et_price);
                et_price.setFocusable(true);
                et_price.setFocusableInTouchMode(true);
                et_price.requestFocus();
                ll_price_select.setVisibility(View.VISIBLE);
            }
        });

        et_price.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                keyboardUtil.attachTo(et_price);
                return false;
            }
        });
        et_orginal_price.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                keyboardUtil.attachTo(et_orginal_price);
                return false;
            }
        });
        et_freight.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                keyboardUtil.attachTo(et_freight);
                return false;
            }
        });
    }

    public boolean validate() {
        if (et_price.getText().toString().equals("")) {
            Toast.makeText(getApplication(), "价格不能为空", Toast.LENGTH_SHORT).show();
            return false;
        } else if (et_orginal_price.getText().toString().equals("")) {
            Toast.makeText(getApplication(), "原价不能为空", Toast.LENGTH_SHORT).show();
            return false;
        } else if (et_freight.getText().toString().equals("")) {
            Toast.makeText(getApplication(), "运费不能为空", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if (ll_price_select.getVisibility() == View.VISIBLE) {
            ll_price_select.setVisibility(View.GONE);
        } else {
            super.onBackPressed();
        }
    }
}
