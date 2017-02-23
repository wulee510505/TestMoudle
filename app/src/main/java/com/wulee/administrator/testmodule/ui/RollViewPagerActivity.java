package com.wulee.administrator.testmodule.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.TextHintView;
import com.wulee.administrator.testmodule.R;
import com.wulee.administrator.testmodule.view.Advertisements;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by wulee on 2016/4/13.
 */
public class RollViewPagerActivity extends AppCompatActivity implements View.OnClickListener{
    private String[] headImageUrl = {"http://www.fh21.com.cn/uploads/allimg/160316/2635_160316160132_1.jpg",
                                     "http://i8.hexunimg.cn/2014-07-18/166771301.jpg",
                                      "http://img1.imgtn.bdimg.com/it/u=394082203,4226819746&fm=11&gp=0.jpg"};
    private LinearLayout llAdvertiseBoard;
    private TextView tvYuYue,tvReport,tvHospital,tvNews,tvMedichineUse,tvJiuZhen,tvWork,tvPingJia,tvJiaoHao;


    private RollPagerView mRollViewPager;
    private LinearLayout ll1,ll2,ll3,ll4,ll5,ll6,ll7;
    private LinearLayout[]  llArray = new LinearLayout[7];


    private TextView mRb1, mRb2, mRb3, mRb4, mRb5, mRb6, mRb7;
    private TextView[]  rbArray = new TextView[7];

    private View line1, line2, line3, line4, line5, line6, line7;
    private View[]  lineArray = new View[7];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rollviewpager);

        mRollViewPager = (RollPagerView) findViewById(R.id.rollpagerview);

        mRollViewPager.setPlayDelay(1000);
        //设置播放时间间隔
        mRollViewPager.setAnimationDurtion(2000);
        //设置适配器
        mRollViewPager.setAdapter(new TestNormalAdapter());


        //mRollViewPager.setHintView(new IconHintView(this, R.drawable.point_focus, R.drawable.point_normal));  //自定义指示器图片
        //mRollViewPager.setHintView(new ColorPointHintView(this, Color.YELLOW, Color.WHITE));  //设置圆点指示器颜色
        mRollViewPager.setHintView(new TextHintView(this));  //设置文字指示器
        //mRollViewPager.setHintView(null);  //隐藏指示器

        ll1= (LinearLayout) findViewById(R.id.ll_1);
        ll2= (LinearLayout) findViewById(R.id.ll_2);
        ll3= (LinearLayout) findViewById(R.id.ll_3);
        ll4= (LinearLayout) findViewById(R.id.ll_4);
        ll5= (LinearLayout) findViewById(R.id.ll_5);
        ll6= (LinearLayout) findViewById(R.id.ll_6);
        ll7= (LinearLayout) findViewById(R.id.ll_7);


        mRb1 = (TextView) findViewById(R.id.tv1);
        mRb2 = (TextView) findViewById(R.id.tv2);
        mRb3 = (TextView) findViewById(R.id.tv3);
        mRb4 = (TextView) findViewById(R.id.tv4);
        mRb5 = (TextView) findViewById(R.id.tv5);
        mRb6 = (TextView) findViewById(R.id.tv6);
        mRb7 = (TextView) findViewById(R.id.tv7);

        line1 = findViewById(R.id.line1);
        line2 = findViewById(R.id.line2);
        line3 = findViewById(R.id.line3);
        line4 = findViewById(R.id.line4);
        line5 = findViewById(R.id.line5);
        line6 = findViewById(R.id.line6);
        line7 = findViewById(R.id.line7);

        rbArray[0] = mRb1;
        rbArray[1] = mRb2;
        rbArray[2] = mRb3;
        rbArray[3] = mRb4;
        rbArray[4] = mRb5;
        rbArray[5] = mRb6;
        rbArray[6] = mRb7;

        lineArray[0] = line1;
        lineArray[1] = line2;
        lineArray[2] = line3;
        lineArray[3] = line4;
        lineArray[4] = line5;
        lineArray[5] = line6;
        lineArray[6] = line7;

        llArray[0] = ll1;
        llArray[1] = ll2;
        llArray[2] = ll3;
        llArray[3] = ll4;
        llArray[4] = ll5;
        llArray[5] = ll6;
        llArray[6] = ll7;


        ll1.setOnClickListener(this);
        ll2.setOnClickListener(this);
        ll3.setOnClickListener(this);
        ll4.setOnClickListener(this);
        ll5.setOnClickListener(this);
        ll6.setOnClickListener(this);
        ll7.setOnClickListener(this);

        //初始化广告轮播
        LayoutInflater inflater = LayoutInflater.from(this);
        llAdvertiseBoard = (LinearLayout) this.findViewById(R.id.llAdvertiseBoard);
        JSONArray advertiseArray = new JSONArray();
        try {
            JSONObject headImg = null;
            for (int i = 0; i < headImageUrl.length; i++) {
                headImg = new JSONObject();
                headImg.put("head_img",headImageUrl[i]);
                advertiseArray.put(headImg);
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        llAdvertiseBoard.addView(new Advertisements(this, true, inflater, 2000).initView(advertiseArray));
    }

    private void initRbTextSizeAndColor(int checkRbId) {
        for(int i=0;i<llArray.length;i++){
            if(llArray[i].getId() == checkRbId){
                TextPaint tp = rbArray[i].getPaint();
                tp.setFakeBoldText(true);
                rbArray[i].setTextColor(getResources().getColor(R.color.default_badge_color));
                lineArray[i].setVisibility(View.VISIBLE);
            }else{
                TextPaint tp = rbArray[i].getPaint();
                tp.setFakeBoldText(false);
                rbArray[i].setTextColor(getResources().getColor(R.color.color_light_blue));
                lineArray[i].setVisibility(View.INVISIBLE);
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_1:
                initRbTextSizeAndColor(R.id.ll_1);
                break;
            case R.id.ll_2:
                initRbTextSizeAndColor(R.id.ll_2);
                break;
            case R.id.ll_3:
                initRbTextSizeAndColor(R.id.ll_3);
                break;
            case R.id.ll_4:
                initRbTextSizeAndColor(R.id.ll_4);
                break;
            case R.id.ll_5:
                initRbTextSizeAndColor(R.id.ll_5);
                break;
            case R.id.ll_6:
                initRbTextSizeAndColor(R.id.ll_6);
                break;
            case R.id.ll_7:
                initRbTextSizeAndColor(R.id.ll_7);
                break;
        }
    }

    private class TestNormalAdapter extends StaticPagerAdapter {
        private int[] imgs = {
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher
        };


        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            view.setImageResource(imgs[position]);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return view;
        }


        @Override
        public int getCount() {
            return imgs.length;
        }
    }
}
