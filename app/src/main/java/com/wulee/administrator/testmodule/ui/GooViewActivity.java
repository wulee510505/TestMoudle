package com.wulee.administrator.testmodule.ui;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.wulee.administrator.testmodule.R;
import com.wulee.administrator.testmodule.utils.ScreenUtils;
import com.wulee.administrator.testmodule.view.StickyFlagView;


/**
 * Created by will wu on 2016/10/21.
 */

public class GooViewActivity extends Activity {

    private StickyFlagView stickyFlagView1=null;
    private StickyFlagView stickyFlagView2=null;
    private RelativeLayout rl=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goo_view_activity);
        initView();
        initData();
        initLisener();
    }

    private void initView(){
        stickyFlagView1 = (StickyFlagView) findViewById(R.id.sticky_view1);
        stickyFlagView2 = (StickyFlagView) findViewById(R.id.sticky_view2);
        rl = (RelativeLayout) findViewById(R.id.rl);
    }

    private void initData(){
        stickyFlagView1.setFlagText("6");
    }

    private void initLisener(){
        stickyFlagView1.setOnFlagDisappearListener(new StickyFlagView.OnFlagDisappearListener() {
            @Override
            public void onFlagDisappear(StickyFlagView view) {
                Toast.makeText(GooViewActivity.this, "清除消息提示！", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.btn_flag).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stickyFlagView1.setFlagText("6");
                stickyFlagView2.setFlagText(null);
            }
        });

        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StickyFlagView sfv = new StickyFlagView(GooViewActivity.this);
                sfv.setFlagText("9");
                sfv.setFlagTextColor(Color.WHITE);
                sfv.setFlagTextSize(ScreenUtils.spTopx(GooViewActivity.this, 15));
                sfv.setFlagColor(Color.BLUE);
                sfv.setFlagRadius(ScreenUtils.dpToPx(GooViewActivity.this, 10));
                sfv.setMinStickRadius(ScreenUtils.dpToPx(GooViewActivity.this, 3));
                sfv.setMaxStickRadius(ScreenUtils.dpToPx(GooViewActivity.this, 8));
                sfv.setMaxDistance(ScreenUtils.dpToPx(GooViewActivity.this, 80));
                //sfv.setFlagDrawable(R.drawable.bubble);
                RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams((int) ScreenUtils.dpToPx(GooViewActivity.this, 40), (int) ScreenUtils.dpToPx(GooViewActivity.this, 40));
                lp.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
                lp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
                rl.addView(sfv, lp);
            }
        });
    }

}
