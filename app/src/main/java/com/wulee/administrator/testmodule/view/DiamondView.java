package com.wulee.administrator.testmodule.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * Created by wulee on 2017/6/5 16:01
 * 菱形view
 */

public class DiamondView extends AppCompatImageView {
    private Paint mPaint;
    private Xfermode mXfermode;

    private int width;
    private int height ;

    public DiamondView(Context context) {
        this(context, null);
    }

    public DiamondView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DiamondView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        // 关键方法
        mXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        width = getMeasuredWidth();
        height = getMeasuredHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Bitmap bm = Bitmap.createBitmap(width,height,Bitmap.Config.ARGB_8888);
        canvas.drawColor(Color.parseColor("#00ff00"));

        Paint paint = new Paint();
        paint.setColor(Color.RED);
        //画笔的风格，就是边框（绘制的是空心的）
        //paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);

        //绘制路径
        Path path = new Path();
        //从哪个点开始绘制
        path.moveTo(0,width/2);
        //然后绘制到哪个点
        path.lineTo(height/2,width);
        //然后再绘制到哪个点
        path.lineTo(height,width/2);
        //然后再绘制到哪个点
        path.lineTo(height/2,0);
        //然后再绘制到哪个点
        path.lineTo(0,width/2);

        //按路径绘制，就是一个菱形
        //canvas.drawPath(path,paint);
        setImageBitmap(bm);

        float sw = getLong(width);

        mPaint.setColor(Color.WHITE);
        float a = (float) Math.sqrt(Math.pow(Math.sqrt(Math.pow(width/2,2)+Math.pow(width/2,2))/2,2)+Math.pow(Math.sqrt(Math.pow(width/2,2)+Math.pow(width/2,2))/2,2));

        //canvas.drawRect(sw,sw,a+sw,a+sw,mPaint);
        canvas.rotate(-45,sw+ a/2,width/2);
        canvas.drawRoundRect(sw,sw,a+sw,a+sw,30.0f,30.0f,mPaint);

      /*  Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        canvas.rotate(45,sw+ a/2,width/2);
        mPaint.setXfermode(mXfermode);
        canvas.drawBitmap(bmp, sw+a/4, sw+a/4, mPaint);
        mPaint.setXfermode(null);*/

    }


    public static float getLong(int a){
        float b = (float) Math.sqrt(Math.pow(a/2,2)+Math.pow(a/2,2));
        System.out.println("菱形边长="+b);
        float c = (float) Math.sqrt(Math.pow(b/2,2)+Math.pow(b/2,2));
        System.out.println("内正方形边长="+c);
        float d=(a-c)/2;
        System.out.println("三角边长="+d);
        return d;
    }


}
