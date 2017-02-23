package com.wulee.administrator.testmodule.ui;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wulee.administrator.testmodule.R;
import com.wulee.administrator.testmodule.view.SideBar;

/**
 * Created by wulee on 2016/6/28 11:43
 */

public class SideBarActivity extends Activity {
    private static final String TAG = MainActivity.class.getSimpleName();

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sidebar);

        textView = (TextView) findViewById(R.id.textView);


        SideBar sideBar = (SideBar) findViewById(R.id.sideBar);
        sideBar.setOnTouchingLetterChangedListener(new SideBar.OnTouchingLetterChangedListener() {
            @Override
            public void onTouchingLetterChanged(String s) {
                Log.d(TAG, "select " + s);
                textView.setText("select " + s);
            }
        });

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("OnClick ");
            }
        });
    }
}
