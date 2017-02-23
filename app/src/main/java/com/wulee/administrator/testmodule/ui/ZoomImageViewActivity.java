package com.wulee.administrator.testmodule.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.wulee.administrator.testmodule.R;
import com.wulee.administrator.testmodule.utils.ImageUtil;
import com.wulee.administrator.testmodule.view.ZoomImageView;

/**
 * Created by wulee on 2016/4/13.
 */
public class ZoomImageViewActivity extends AppCompatActivity {

    private Context mContext = null;
    private ViewPager mViewPager = null;

    private String[] imageurl = new String[]{
            "http://image5.tuku.cn/pic/wallpaper/fengjing/weimeishijiefengjing/006.jpg",
            "http://img14.poco.cn/mypoco/myphoto/20130403/14/65939719201304031356532142558851773_032.jpg",
            "http://www.zqlnn.com/imageRepository/fcd1b8fb-a6cd-471e-a267-8b7a9fd1594a.jpg"
    };
    private ImageView[] mImageViews = new ImageView[imageurl.length];




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zoom_imageview_viewpager);

        mContext = ZoomImageViewActivity.this;
        mViewPager = (ViewPager) findViewById(R.id.id_viewPager);
        mViewPager.setAdapter(new PagerAdapter() {

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ZoomImageView zoomImageView = new ZoomImageView(mContext);
                //zoomImageView.setImageResource(mImgs[position]);
                ImageUtil.setDefaultImageView(zoomImageView,imageurl[position],R.mipmap.ic_launcher,mContext);
                container.addView(zoomImageView);
                //这个ImageView数组的作用是暂存一个个的ZoomImageView对象，目的是方便以后删除
                mImageViews[position] = zoomImageView;
                return zoomImageView;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                //到这里ImageView数组就派上大用场了
                container.removeView(mImageViews[position]);
            }

            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                return arg0 == arg1;
            }

            @Override
            public int getCount() {
                return mImageViews.length;
            }
        });
    }

}
