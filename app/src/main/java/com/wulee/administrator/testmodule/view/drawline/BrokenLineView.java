package com.wulee.administrator.testmodule.view.drawline;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by wulee on 2016/9/20 09:50
 */

public class BrokenLineView extends View {
    //坐标轴原点的位置
    private int xPoint= 60;
    private int yPoint= 480;
    //刻度长度
    private int xScale= 20;  //20个单位构成一个刻度
    private int yScale= 80;
    //x与y坐标轴的长度
    private int xLength;
    private int yLength;

    private int MaxDataSize;   //横坐标  最多可绘制的点

    private List<Integer> data=new ArrayList<Integer>();   //存放 纵坐标 所描绘的点

    private String[] xLabel;  //Y轴的刻度上显示字的集合
    private String[] yLabel;  //Y轴的刻度上显示字的集合


    private Handler mh=new Handler(){
        public void handleMessage(android.os.Message msg) {
            if(msg.what==0){                //判断接受消息类型
                BrokenLineView.this.invalidate();  //刷新View
            }
        };
    };

    public BrokenLineView(Context context, AttributeSet attrs) {
        super(context, attrs);
        xLength = getScreenWidthAndHeight()[0]-120;
        yLength = getScreenWidthAndHeight()[1]/2;
        xLabel =  new String[xLength/xScale];
        yLabel =  new String[yLength/yScale];

        MaxDataSize = xLength/xScale;

        for (int i = 0; i <yLabel.length; i++) {
            yLabel[i]=(i+1)+"M/s";
        }
        for (int i = 0; i <xLabel.length; i++) {
            xLabel[i]=(i+1)+"";
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){     //在线程中不断往集合中增加数据
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(data.size()>MaxDataSize){  //判断集合的长度是否大于最大绘制长度
                        data.remove(0);  //删除头数据
                    }
                    data.add(new Random().nextInt(7)+1);  //生成1-8的随机数
                    mh.sendEmptyMessage(0);   //发送空消息通知刷新
                }
            }
        }).start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint=new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setColor(Color.RED);
        //绘制Y轴
        canvas.drawLine(xPoint, yPoint-yLength, xPoint, yPoint, paint);
        //绘制Y轴左右两边的箭头
        canvas.drawLine(xPoint, yPoint-yLength, xPoint-3,yPoint-yLength+6, paint);
        canvas.drawLine(xPoint, yPoint-yLength, xPoint+3,yPoint-yLength+6, paint);
        //Y轴上的刻度与文字
        for (int i = 0; i * yScale< yLength; i++) {
            canvas.drawLine(xPoint, yPoint-i*yScale, xPoint+5, yPoint-i*yScale, paint);  //刻度
            canvas.drawText(yLabel[i], xPoint-50, yPoint-i*yScale, paint);//Y轴文字
        }

        //X轴
        canvas.drawLine(xPoint, yPoint, xPoint+xLength, yPoint, paint);
        //绘制X轴上下两边的箭头
        canvas.drawLine(xPoint+xLength, yPoint, xPoint+xLength-6,yPoint-3, paint);
        canvas.drawLine(xPoint+xLength, yPoint, xPoint+xLength-6,yPoint+3, paint);
        //X轴上的刻度与文字
        for (int j = 0; j * xScale< xLength; j++) {
            canvas.drawLine(xPoint+ j*xScale,  yPoint, xPoint + j*xScale, yPoint-5, paint);  //刻度
            canvas.drawText(xLabel[j], xPoint+j*xScale, yPoint+20, paint);//X轴文字
        }

        //如果集合中有数据
      /* if(data.size()>1){
            for (int i = 1; i < data.size(); i++) {  //依次取出数据进行绘制
                canvas.drawLine(xPoint+(i-1)*xScale, yPoint-data.get(i-1)*yScale, xPoint+i*xScale, yPoint-data.get(i)*yScale, paint);
            }
        }*/
        for (int i = 1; i < data.size(); i++) {  //依次取出数据进行绘制
            canvas.drawLine(xPoint+(data.size()-i)*xScale, yPoint-data.get(i-1)*yScale, xPoint+(data.size()-i-1)*xScale, yPoint-data.get(i)*yScale, paint);
        }
    }


    private int[] getScreenWidthAndHeight(){
        WindowManager wm = (WindowManager)getContext().getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();
        return new int[]{width,height};
    }
}
