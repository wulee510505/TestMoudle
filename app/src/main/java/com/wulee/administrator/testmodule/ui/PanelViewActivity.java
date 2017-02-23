package com.wulee.administrator.testmodule.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;

import com.wulee.administrator.testmodule.R;
import com.wulee.administrator.testmodule.view.PanelView;
import com.wulee.administrator.testmodule.view.WaveLoadingView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by wulee on 2016/4/13.
 */
public class PanelViewActivity extends AppCompatActivity {
    private PanelView mPanelView,mPanelView2;
    private SeekBar mSeekBar;
    private WaveLoadingView mWaveLoadingView;


    private  int mProgress = 0;

    private final Timer mTimer= new Timer();
    private TimerTask mTask;
    private Handler mHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.panelview);

        mPanelView = (PanelView) findViewById(R.id.panelView);
        mPanelView2 = (PanelView) findViewById(R.id.panelView2);
        mWaveLoadingView = (WaveLoadingView) findViewById(R.id.waveLoadingView);

        mSeekBar = (SeekBar) findViewById(R.id.seekBar);
        mPanelView.setText("已完成");
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mPanelView.setPercent(progress);
                mPanelView2.setPercent(100-progress);
                mWaveLoadingView.setPercent(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                if(msg.arg1 <= 100){
                    mSeekBar.setProgress(msg.arg1);
                    mWaveLoadingView.setPercent(msg.arg1);
                }
                super.handleMessage(msg);
            }
        };

        mTask = new TimerTask() {
            @Override
            public void run() {
                Message message = new Message();
                message.what = 1;
                message.arg1 = mProgress++;
                mHandler.sendMessage(message);
            }
        };
        mTimer.schedule(mTask,0, 200);
    }
}
