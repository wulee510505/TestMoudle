package com.wulee.administrator.testmodule.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import com.wulee.administrator.testmodule.R;
import com.wulee.administrator.testmodule.utils.SystemUtils;

/**
 * Created by wulee on 2016/5/12.
 */
public class DrawTestView extends View {

    private Paint mPaint;

    private  int screenWidth;
    private int screenHeight;
    private  Context mContext;

    public DrawTestView(Context context) {
        super(context);
        mContext = context;
        init();
    }

    private void init() {
        screenWidth = SystemUtils.getScreenWidthAndHeight(mContext)[0];
        screenHeight = SystemUtils.getScreenWidthAndHeight(mContext)[1];

        mPaint = new Paint();
        mPaint.setColor(Color.parseColor("#ff0000"));
        mPaint.setStrokeWidth(2);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setTextSize(30);
        canvas.drawCircle(200,200,150,mPaint);


        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);


    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

}
