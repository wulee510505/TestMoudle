package com.wulee.administrator.testmodule.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.wulee.administrator.testmodule.R;

/**
 * Created by wulee on 2016/8/12 15:58
 */

public class CircleMenu extends View {

    private Paint paint=new Paint();
    private SeeView[] seeViews;
    private static final int MenuCount=5;//桌面图标的个数
    private int pointX=0,pointY=0;//圆心坐标
    private int radius=150;//半径
    private int DegreeOfPoint;//两个点之间的角度
    public CircleMenu(Context context, int x, int y, int radiu) {
        super(context);
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(2);
        pointX=x;
        pointY=y;
        radius=radiu;
        SetPoint();
        CalculateCoordinate();
        // TODO Auto-generated constructor stub
    }
    /*
     * 这个函数是设置每一个点
     */
    private void SetPoint() {
        // TODO Auto-generated method stub
        seeViews=new SeeView[MenuCount];
        //SeeView seeView;
        int angle=0;
        DegreeOfPoint=360/MenuCount;
        for (int i = 0; i <MenuCount; i++) {
            seeViews[i]=new SeeView();
            seeViews[i].angle=angle;
            seeViews[i].bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher);
            angle+=DegreeOfPoint;
        }
    }
    private void resetPointAngle(float x,float y){
        int angle=CalculateAngle(x, y);
        for (int i = 0; i < MenuCount; i++) {
            seeViews[i].angle=angle;
            angle+=DegreeOfPoint;
        }
    }
    //计算坐标
    private void CalculateCoordinate(){
        SeeView seeView;
        for (int i = 0; i < MenuCount; i++) {
            seeView=seeViews[i];
            seeView.x=pointX+(float)(radius*Math.cos(seeView.angle*Math.PI/180));
            seeView.y=pointY+(float)(radius*Math.sin(seeView.angle*Math.PI/180));
        }
    }
    private int CalculateAngle(float x,float y) {
        float distance=(float)Math.sqrt((x-pointX)*(x-pointX)+(y-pointY)*(y-pointY));
        int degree=(int)(Math.acos((x-pointX)/distance)*180/Math.PI);
        if (y<pointY) {
            degree=-degree;
        }
        return degree;
    }

    public boolean dispatchTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub
        //Animation animation;
        //animation=AnimationUtils.loadAnimation(getContext(), R.anim.scale);
        resetPointAngle(event.getX(), event.getY());
        CalculateCoordinate();
        invalidate();
        return true;
    }


    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        canvas.drawPoint(pointX, pointY, paint);
        for (int i = 0; i < MenuCount; i++) {
            if (!seeViews[i].isVisible)
                continue;
            drawIncenter(canvas, seeViews[i].bitmap, seeViews[i].x, seeViews[i].y);
        }
        super.onDraw(canvas);
    }

    private void drawIncenter(Canvas canvas, Bitmap bitmap, float left, float top)
    {
        canvas.drawPoint(left, top, paint);
        Log.i("-------->", left+"");
        Log.i("----------------->", bitmap.getWidth()/2+"");
        canvas.drawBitmap(bitmap, left+bitmap.getWidth()/2, top+bitmap.getHeight()/2,null);
    }
    private class SeeView{
        Bitmap bitmap;//每个图标的图
        float x,y;//每个图标的坐标
        int angle;//角度
        boolean isVisible=true;//是否可见，当然可见，要不怎么看见
    }
}
