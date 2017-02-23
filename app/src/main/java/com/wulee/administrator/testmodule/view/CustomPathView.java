package com.wulee.administrator.testmodule.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
/**
 * Created by wulee on 2016/7/14 16:28
 */

public class CustomPathView extends View {
    private final String DEFAULT_TEXT = "文 字 按 照 路 径 曲 线 显 示";
    private Paint paint;
    private Path[] paths = new Path[3];

    public CustomPathView(Context context) {
        super(context);
        initView();
    }


    public CustomPathView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public CustomPathView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(4);
        paths[0] = new Path();
        paths[0].moveTo(0, 0);
        for (int i = 0; i < DEFAULT_TEXT.length(); i++) {
            //生成6个点，随机生成Y坐标，并且连在一起
            paths[0].lineTo(i * 30, (float) (Math.random() * 30));
        }
        paths[1] = new Path();
        RectF oval = new RectF(0, 0, 400, 200);
        paths[1].addOval(oval, Path.Direction.CCW);//椭圆路径
        paths[2] = new Path();
        paths[2].addArc(oval, 60, 180);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //背景白色
        canvas.drawColor(Color.WHITE);
        canvas.translate(240, 80);

        //右边开始绘制，对齐
        paint.setTextAlign(Paint.Align.RIGHT);
        paint.setTextSize(40);

      /*  //绘制路径
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(paths[0], paint);*/

        //绘制文字
        paint.setStyle(Paint.Style.FILL);
        canvas.drawTextOnPath(DEFAULT_TEXT, paths[0], -8, 10, paint);
        //下移
        canvas.translate(0, 150);
        //绘制路径
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(paths[1], paint);
        //绘制文字
        paint.setStyle(Paint.Style.FILL);
        canvas.drawTextOnPath(DEFAULT_TEXT, paths[1], -20, -20, paint);
        //下移
        canvas.translate(0, 300);
        //绘制路径
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(paths[2], paint);

        //绘制文字
        paint.setStyle(Paint.Style.FILL);
        canvas.drawTextOnPath(DEFAULT_TEXT, paths[2], -10, -20, paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }
}
