package com.wulee.administrator.testmodule.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by wulee on 2016/4/5.
 */
public class TwinkleLoveView extends SurfaceView implements SurfaceHolder.Callback,Runnable {
    boolean mbloop = false;

    SurfaceHolder mSurfaceHolder = null;

    private Canvas canvas;

    int minCount  = 0;

    int y = 50;

    public TwinkleLoveView(Context context)
    {
        super(context);

        mSurfaceHolder = this.getHolder();

        mSurfaceHolder.addCallback(this);

        this.setFocusable(true);

        this.setKeepScreenOn(true);

        mbloop = true;

    }


    @Override
    public void run()
    {
        // TODO Auto-generated method stub
        while(mbloop)
        {
            try
            {
                Thread.sleep(200);

            } catch (Exception e) {
                // TODO: handle exception
            }
            synchronized (mSurfaceHolder)
            {
                draw();
            }
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
                               int height) {
        // TODO Auto-generated method stub

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder)
    {
        // TODO Auto-generated method stub
        new Thread(this).start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder)
    {
        // TODO Auto-generated method stub
        mbloop = false;
    }

    private void draw()
    {
        canvas = mSurfaceHolder.lockCanvas();
        try
        {
            if(mSurfaceHolder == null || canvas == null)
            {
                return;
            }
            if(minCount < 100)
            {
                minCount ++;
            }
            else
            {
                minCount = 0;
            }
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(Color.BLACK);
            canvas.drawRect(0, 0,320,480,paint);
            switch (minCount % 6)
            {
                case 0:
                    paint.setColor(Color.YELLOW);
                    break;
                case 1:
                    paint.setColor(Color.BLUE);
                    break;
                case 2:
                    paint.setColor(Color.GREEN);
                    break;
                case 3:
                    paint.setColor(Color.RED);
                    break;
                case 4:
                    paint.setColor(Color.argb(255, 255, 181, 216));
                    break;
                case 5:
                    paint.setColor(Color.argb(255, 0, 255, 255));
                    break;
                default:
                    break;
            }

            int i, j;

            double x, y, r;


            for (i = 0; i <= 90; i++) {

                for (j = 0; j <= 90; j++) {
                    r = Math.PI / 45 * i * (1 - Math.sin(Math.PI / 45 * j))

                            * 20;

                    x = r * Math.cos(Math.PI / 45 * j)

                            * Math.sin(Math.PI / 45 * i) + 320 / 2;

                    y = -r * Math.sin(Math.PI / 45 * j) + 400 / 4;

                    canvas.drawPoint((float) x, (float) y, paint);

                }

            }
            paint.setTextSize(32);

            paint.setTypeface(Typeface.create(Typeface.SERIF, Typeface.ITALIC));


            RectF rect = new RectF(60, 400, 260, 405);

            canvas.drawRoundRect(rect, (float) 1.0, (float) 1.0, paint);

            canvas.drawText("Loving You", 75, 400, paint);

            mSurfaceHolder.unlockCanvasAndPost(canvas);


        }
        catch (Exception e)
        {
            // TODO: handle exception
        }
    }

}
