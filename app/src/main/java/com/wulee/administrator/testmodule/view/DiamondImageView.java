package com.wulee.administrator.testmodule.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * Created by wulee on 2017/6/5 16:01
 */

public class DiamondImageView extends AppCompatImageView {
    private Paint mPaint;
    private Xfermode mXfermode;
    private Bitmap mRectMask;

    public DiamondImageView(Context context) {
        this(context, null);
    }

    public DiamondImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DiamondImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.RED);
        // 关键方法
        mXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        createMask();
    }

    private void createMask() {
        if (mRectMask == null) {
            int maskWidth = getMeasuredWidth();
            int maskHeight = getMeasuredHeight();
            mRectMask = Bitmap.createBitmap(maskWidth, maskHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(mRectMask);
            canvas.translate(maskWidth / 2, 0);
            canvas.rotate(45);
            int rectSize = (int) (maskWidth / 2 / Math.sin(Math.toRadians(45)));
            canvas.drawRect(0, 0, rectSize, rectSize, mPaint);
        }
    }


    @Override
    protected void onDraw(Canvas canvas) {
        int id = canvas.saveLayer(0, 0, canvas.getWidth(), canvas.getHeight(), null, Canvas.ALL_SAVE_FLAG);
        super.onDraw(canvas);
        // 关键方法
        mPaint.setXfermode(mXfermode);
        canvas.drawBitmap(mRectMask, 0, 0, mPaint);
        mPaint.setXfermode(null);
        canvas.restoreToCount(id);
    }
}
