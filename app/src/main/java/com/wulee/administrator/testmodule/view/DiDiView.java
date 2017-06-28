package com.wulee.administrator.testmodule.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;

/**
 * Created by wulee on 2017/6/27 14:01
 */

public class DiDiView extends View {

    //时间
    long time =0;
    //倒计时的文本
    String outText = "";
    //外圈的圆环 路径
    Path pathCicle;
    //测量的类
    PathMeasure measure;
    //路径的总长度
    float pathLength = 0;
    //圆的 x ，y坐标---也就是球心的坐标
    float xy [] ;
    //做过的圆环路径
    Path workePath;
    //画笔
    Paint paint;
    //屏幕宽高
    int w;
    int h;
    public DiDiView(Context context) {
        this(context,null);
    }

    public DiDiView(Context context, @Nullable AttributeSet attrs) {
        this(context,attrs,0);
    }

    public DiDiView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        w = wm.getDefaultDisplay().getWidth();
        h = wm.getDefaultDisplay().getHeight();


        paint = new Paint();
        paint.setDither(true);
        paint.setAntiAlias(true);
        //初始化path
        initPath();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //移动画布圆心
        canvas.translate(w/2,h/2);
        //固定圆环
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);
        paint.setColor(Color.parseColor("#f5dcc0"));
        canvas.drawCircle(0,0,300,paint);

        //绘制走过的路径
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(9);
        paint.setColor(Color.parseColor("#f4bf69"));
        canvas.drawPath(workePath,paint);
        //绘制移动的圆
        paint.setColor(Color.parseColor("#f19734"));
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawCircle(xy[0],xy[1],50,paint);
        //绘制移动圆的时间
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);
        paint.setTextSize(35);
        canvas.drawText(outText,xy[0]-39,xy[1]+10,paint);
    }

    /**
     * 初始化路径
     */
    public void initPath(){
        //细圆环
        pathCicle = new Path();
        RectF rectF = new RectF(-300,-300,300,300);
        pathCicle.addArc(rectF,270,359.9f);
        measure = new PathMeasure();
        measure.setPath(pathCicle,false);
        //出圆环的path
        workePath = new Path();
        //总路径长
        pathLength = measure.getLength();
        xy = new float[2];
        initAnimation();
    }


    /**
     * 动画
     */
    public void initAnimation(){

        ValueAnimator animator = ValueAnimator.ofFloat(0,pathLength);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                float currentlenght  = (float) animation.getAnimatedValue();
                //获取当前路径长度的终点
                measure.getPosTan(currentlenght,xy,null);
                //截取路径
                measure.getSegment(0,currentlenght,workePath,true);
                //获取动画时长
                time = (animation.getDuration() - animation.getCurrentPlayTime());
                if (time>0){
                    outText = "00:0"+(time/1000+1);
                }else {
                    outText = "00:00";
                }

                postInvalidate();
            }
        });
        animator.setInterpolator(new LinearInterpolator());
        animator.setDuration(8000);
        animator.start();
    }
}
