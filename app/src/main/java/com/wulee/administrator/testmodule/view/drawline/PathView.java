package com.wulee.administrator.testmodule.view.drawline;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;

/**
 * Created by wing on 16/3/30.
 */
public class PathView extends CardiographView {
    public PathView(Context context) {
        this(context,null);
    }

    public PathView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public PathView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPath = new Path();
    }


    private void drawPath(Canvas canvas) {
        // 重置path
        mPath.reset();

        //用path模拟一个心电图样式
        mPath.moveTo(0,mHeight);
        int tmp = 0;
        for(int i = 10;i>0;i--) {
            mPath.lineTo(tmp+20, 100);
            mPath.lineTo(tmp+70, mHeight / 2 + 50);
            mPath.lineTo(tmp+80, mHeight / 2);

            mPath.lineTo(tmp+200, mHeight / 2);
            tmp = tmp+200;
            Log.i("tag:","tmp="+tmp+"; mHeight="+mHeight);
        }
        //设置画笔style
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(mLineColor);
        mPaint.setStrokeWidth(5);
        canvas.drawPath(mPath,mPaint);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawPath(canvas);
        scrollBy(1,0);
        postInvalidateDelayed(10);
    }


}
