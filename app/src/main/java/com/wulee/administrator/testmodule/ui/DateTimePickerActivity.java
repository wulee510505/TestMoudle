package com.wulee.administrator.testmodule.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.wulee.administrator.testmodule.R;
import com.wulee.administrator.testmodule.utils.DateTimePickDialogUtil;

/**
 * Created by wulee on 2016/4/1.
 */
public class DateTimePickerActivity extends Activity {
    private EditText startDateTime;

    private String initStartDateTime = "2016年4月1日 14:44"; // 初始化开始时间

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datetime_picker);

        // 两个输入框
        startDateTime = (EditText) findViewById(R.id.inputDate);

        startDateTime.setText(initStartDateTime);

        startDateTime.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                DateTimePickDialogUtil dateTimePicKDialog = new DateTimePickDialogUtil(
                        DateTimePickerActivity.this, initStartDateTime);
                dateTimePicKDialog.dateTimePicKDialog(startDateTime);

            }
        });
    }
}
