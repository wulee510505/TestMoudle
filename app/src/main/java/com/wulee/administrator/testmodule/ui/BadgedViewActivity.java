package com.wulee.administrator.testmodule.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.wulee.administrator.testmodule.R;
import com.wulee.administrator.testmodule.view.CircleBadgedView;
import com.wulee.administrator.testmodule.view.RecBadgedView;
import com.wulee.administrator.testmodule.view.TriBadgedView;

/**
 * Created by wulee on 2016/4/13.
 */
public class BadgedViewActivity extends Activity implements View.OnClickListener{

    private CircleBadgedView circleView;

    private RecBadgedView anyView;
    private RecBadgedView scaleView;
    private RecBadgedView regularView;

    private TriBadgedView triView;

    private CircleBadgedView circleBadgedView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.badgedview);

        circleView = (CircleBadgedView) findViewById(R.id.badge_circle_view);
        anyView = (RecBadgedView) findViewById(R.id.badge_any_view);
        scaleView = (RecBadgedView) findViewById(R.id.badge_scale_view);
        regularView = (RecBadgedView) findViewById(R.id.badge_regular_view);
        //circleBadgedView = (CircleBadgedView) findViewById(R.id.badge_circle_view);

        triView = (TriBadgedView) findViewById(R.id.badge_tri_view);

        circleView.showBadge(true);

        anyView.setBadgeText("I'm badge");
        anyView.setOnClickListener(this);
        anyView.showBadge(true);

        scaleView.showBadge(true);
        regularView.showBadge(true);

        triView.showBadge(true);
        //circleBadgedView.showBadge(true);
    }

    @Override
    public void onClick(View v) {
        if(anyView.isBadgeVisible()){
            anyView.showBadge(false);
        } else {
            anyView.showBadge(true);
        }
    }
}
