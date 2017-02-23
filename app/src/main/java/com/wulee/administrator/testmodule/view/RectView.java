package com.wulee.administrator.testmodule.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

/**
 *
 * 类似播放音乐的条形图
 * Created by Alex_MaHao on 2016/3/15.
 */
public class RectView extends View {


    /**
     * 控件的宽度
     */
    private int mWidth;

    /**
     * 条形的高度
     */
    private int mRectHeight;

    /**
     * 条形的宽度
     */
    private int mRectWidth;

    /**
     * 条形的数量
     */
    private int mRectCount = 5;
    /**
     * 颜色的渲染器
     */
    private LinearGradient mLinearGradient;

    /**
     * 画笔
     */
    private Paint mPaint;
    /**
     * 随机条形的高度
     */
    private double mRandom;

    public RectView(Context context) {
        super(context,null);
    }

    public RectView(Context context, AttributeSet attrs) {
        super(context, attrs);

        /**
         * 初始化画笔
         */
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        //控件的宽度
        mWidth = getWidth();

        //条形的最大高度，最低端的坐标
        mRectHeight = getHeight();

        //条形图占总宽度的位置
        mRectWidth = (int) (mWidth*0.6/mRectCount);

        //渲染器，
        mLinearGradient = new LinearGradient(0,0,mRectWidth,mRectHeight, Color.YELLOW,Color.BLUE, Shader.TileMode.CLAMP);

        //设置渲染器
        mPaint.setShader(mLinearGradient);


    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for(int i=0;i<mRectCount;i++){
            //获取随机数，获得条形的高度
            mRandom = Math.random();
            float currentHeight = (float) (mRectHeight*mRandom);

            //画出条形图
            canvas.drawRect((float)(mWidth*0.4/2+mRectWidth*i),
                        currentHeight,
                    (float)( mWidth*0.4/2+mRectWidth*(i+1)),
                        mRectHeight,
                    mPaint
                    );
        }
        //300ms刷新视图，改变条形图
        postInvalidateDelayed(300);
    }
}
