package com.wulee.administrator.testmodule.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.wulee.administrator.testmodule.R;
import com.wulee.administrator.testmodule.view.AdCountDownView;

/**
 * Created by wulee on 2016/10/12 15:57
 */

public class AdCountdownActiviy  extends AppCompatActivity{

    private  final int MSG_STAT_TIME_COUNT_DOWN = 100;

    private long lastTime;
    private AdCountDownView count_down_view;


    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case MSG_STAT_TIME_COUNT_DOWN:
                    count_down_view.start();
                break;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_down_view);
        initView();
    }

    private void initView() {
        count_down_view = (AdCountDownView) findViewById(R.id.countDownView);
        count_down_view.setCountDownTimerListener(new AdCountDownView.CountDownTimerListener() {
            @Override
            public void onStartCount() {
                Toast.makeText(AdCountdownActiviy.this,"开始计时",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFinishCount() {
                Toast.makeText(AdCountdownActiviy.this,"计时结束",Toast.LENGTH_SHORT).show();
                AdCountdownActiviy.this.finish();
            }
        });
        count_down_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count_down_view.stop();
                AdCountdownActiviy.this.finish();
            }
        });

        mHandler.sendEmptyMessageDelayed(MSG_STAT_TIME_COUNT_DOWN,2000);
    }

    //连按两次退出应用程序
    @Override
    public void onBackPressed() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastTime < 2 * 1000) {
            super.onBackPressed();
        } else {
            Toast.makeText(this, "请再按一次", Toast.LENGTH_SHORT).show();
            lastTime = currentTime;
        }
    }
}
