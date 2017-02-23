package com.wulee.administrator.testmodule.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.wulee.administrator.testmodule.R;
import com.wulee.administrator.testmodule.view.LabelView;

/**
 * Created by wulee on 2016/10/12 17:28
 */

public class LableViewActivity extends AppCompatActivity {

    private LabelView mLabelView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lableview_activity);
        mLabelView = (LabelView) findViewById(R.id.labelview1);

        mLabelView.setOnDelBtnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LableViewActivity.this,"delete",Toast.LENGTH_SHORT).show();
            }
        });
        mLabelView.setOnLableTextClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LableViewActivity.this,mLabelView.getLableText(),Toast.LENGTH_SHORT).show();
            }
        });

    }
}
