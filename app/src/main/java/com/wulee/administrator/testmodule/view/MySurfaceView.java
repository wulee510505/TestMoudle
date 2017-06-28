package com.wulee.administrator.testmodule.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.Random;

/**
 * Created by wulee on 2017/6/26 17:33
 */

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private SurfaceHolder holder;
    public MySurfaceView(Context context)
    {
        super(context);
        holder = this.getHolder();//获取holder
        holder.addCallback(this);
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height)
    {
        new Thread(new MyThread()).start();
    }

    public void surfaceCreated(SurfaceHolder holder)
    {     }

    public void surfaceDestroyed(SurfaceHolder holder)
    {
        // TODO Auto-generated method stub
    }

    class MyThread implements Runnable
    {
        public void run()
        {
            Paint mPaint = new Paint();
            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setAntiAlias(true);
            Random random = new Random();
            Canvas canvas = null;

            Bitmap bak = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            Canvas bakCanvas = new Canvas(bak);
            int rotate = 0;
            while (rotate < 100)
            {
                long before = System.currentTimeMillis();
                rotate = rotate + 1;
                try {
                    canvas = holder.lockCanvas();//获取canvas
                    mPaint.setColor(Color.rgb(random.nextInt(255), random.nextInt(255),random.nextInt(255)));
                    mPaint.setStrokeWidth(2);/*设置paint的外框宽度*/
                    Path mPath = new Path();
                    mPath.moveTo(random.nextInt(450), random.nextInt(600));
                    mPath.lineTo(random.nextInt(300), random.nextInt(400));
                    mPath.lineTo(random.nextInt(200), random.nextInt(300));
                    mPath.close();
                    bakCanvas.drawPath(mPath, mPaint);
                    canvas.drawBitmap(bak, 0, 0, null);
                    before = System.currentTimeMillis() - before;
                    if (before < 17)
                    {
                        Thread.sleep(17 - before); //休眠
                    }
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    holder.unlockCanvasAndPost(canvas); //解锁canvas，提交画好的图像
                }
            }
        }
    }
}
