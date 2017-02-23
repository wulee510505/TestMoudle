package com.wulee.administrator.testmodule.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.wulee.administrator.testmodule.R;

/**
 * Created by wulee on 2016/4/13.
 */
public class ApplaudAnimationActivity extends Activity implements View.OnClickListener {
    private Button button;
    private TextView textView;
    private android.view.animation.Animation animation;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation);

        animation = AnimationUtils.loadAnimation(this,R.anim.applaud_animation);
        button = (Button) findViewById(R.id.bt);
        button.setOnClickListener(this);
        textView = (TextView) findViewById(R.id.animation);
    }

    @Override
    public void onClick(View v) {
        if (v == button) {
            textView.setVisibility(View.VISIBLE);
            textView.startAnimation(animation);
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    textView.setVisibility(View.GONE);
                }
            }, 1000);
        }

    }
}
