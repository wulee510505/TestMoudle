package com.wulee.administrator.testmodule.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.wulee.administrator.testmodule.R;
import com.wulee.administrator.testmodule.animation.CubeAnimation;
import com.wulee.administrator.testmodule.animation.FlipAnimation;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by wulee on 2016/4/13.
 */
public class AnimationTestActivity extends AppCompatActivity {
    private ImageView mImageView1,mImageView2,mImageView3,mImageView4,
                      mImageView5,mImageView6,mImageView7,mImageView8;

    private Timer timer = new Timer(true);

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_test);

        mImageView1 = (ImageView) findViewById(R.id.imageview1);
        mImageView2 = (ImageView) findViewById(R.id.imageview2);
        mImageView3 = (ImageView) findViewById(R.id.imageview3);
        mImageView4 = (ImageView) findViewById(R.id.imageview4);

        mImageView5 = (ImageView) findViewById(R.id.imageview5);
        mImageView6 = (ImageView) findViewById(R.id.imageview6);
        mImageView7 = (ImageView) findViewById(R.id.imageview7);
        mImageView8 = (ImageView) findViewById(R.id.imageview8);

        mImageView1.setAnimation(CubeAnimation.create(CubeAnimation.UP, true, 3000));

        new Handler().postDelayed(new Runnable() {
            public void run() {
                mImageView2.setAnimation(CubeAnimation.create(CubeAnimation.DOWN, false, 3000));
            }
        }, 1000);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                mImageView3.setAnimation(CubeAnimation.create(CubeAnimation.LEFT, true, 3000));
            }
        }, 2000);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                mImageView4.setAnimation(CubeAnimation.create(CubeAnimation.RIGHT, false, 3000));
            }
        }, 3000);

        mImageView5.setAnimation(FlipAnimation.create(FlipAnimation.UP, true, 3000));
        mImageView6.setAnimation(FlipAnimation.create(FlipAnimation.DOWN, false, 3000));
        mImageView7.setAnimation(FlipAnimation.create(FlipAnimation.LEFT, true, 3000));
        mImageView8.setAnimation(FlipAnimation.create(FlipAnimation.RIGHT, false, 3000));


        //启动定时器
        timer.schedule(task, 0, 2000);
    }


    private TimerTask task = new TimerTask() {
        public void run() {
            Message msg = new Message();
            msg.what = 1;
            handler.sendMessage(msg);
        }
    };


    private Handler handler  = new Handler(){
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){

            }
        }
    };
}
