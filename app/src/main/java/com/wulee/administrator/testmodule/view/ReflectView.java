package com.wulee.administrator.testmodule.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import com.wulee.administrator.testmodule.R;

public class ReflectView extends View {

    private Bitmap mSrcBitmap;
    private Bitmap mRefBitmap;
    private Paint mPaint;

    public ReflectView(Context context) {
        super(context);
        initView();
    }

    public ReflectView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public ReflectView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        mSrcBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.icon);
        Matrix matrix = new Matrix();
        matrix.setScale(1, -1);
        mRefBitmap = Bitmap.createBitmap(mSrcBitmap, 0, 0, mSrcBitmap.getWidth(),
                mSrcBitmap.getHeight(), matrix, true);
        mPaint = new Paint();
        mPaint.setShader(new LinearGradient(0, mSrcBitmap.getHeight(),
                0, mSrcBitmap.getHeight() * 1.4F,
                0XDDFFFFFF, 0XFFFFFFFF, Shader.TileMode.CLAMP));
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.BLACK);
        canvas.drawBitmap(mSrcBitmap, 0, 0, null);
        canvas.drawBitmap(mRefBitmap, 0, mSrcBitmap.getHeight(), null);
        canvas.drawRect(0, mRefBitmap.getHeight(), mRefBitmap.getWidth(),
                mRefBitmap.getHeight() * 2, mPaint);
    }
}
