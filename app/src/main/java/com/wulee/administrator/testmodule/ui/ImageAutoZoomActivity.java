package com.wulee.administrator.testmodule.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.wulee.administrator.testmodule.R;

/**
 * Created by wulee on 2016/9/28 17:15
 */

public class ImageAutoZoomActivity extends AppCompatActivity {

    private String imgurl = "http://pic31.nipic.com/20130726/12450036_102611291151_2.jpg";

    private static final int ANIMATION_DURATION = 4000;
    private static final float SCALE_END = 1.8F;

    ImageView mLuanchImage;

    private Handler mHandler = new Handler()
    {
        @Override
        public void handleMessage(Message msg)
        {
            super.handleMessage(msg);
            if (msg.what == 0)
            {
                animateImage();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imageview_auto_zoom_activity);

        mLuanchImage  = (ImageView) findViewById(R.id.iv_luanch);
    }

    @Override
    protected void onResume() {
        getLuanchImage();
        super.onResume();
    }

    private void getLuanchImage() {
        Glide.with(ImageAutoZoomActivity.this).load(imgurl).diskCacheStrategy(DiskCacheStrategy.ALL).error(R.drawable.ic_launcher).into(mLuanchImage);
        mHandler.sendEmptyMessageDelayed(0, 1000);
    }

    private void animateImage() {

        ObjectAnimator animatorX = ObjectAnimator.ofFloat(mLuanchImage, "scaleX", 1f, SCALE_END);
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(mLuanchImage, "scaleY", 1f, SCALE_END);

        AnimatorSet set = new AnimatorSet();
        set.setDuration(ANIMATION_DURATION).play(animatorX).with(animatorY);
        set.start();

        set.addListener(new AnimatorListenerAdapter()
        {
            @Override
            public void onAnimationEnd(Animator animation)
            {
                startActivity(new Intent(ImageAutoZoomActivity.this, MainActivity.class));
                ImageAutoZoomActivity.this.finish();
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);
    }
}