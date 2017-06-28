package com.wulee.administrator.testmodule.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.wulee.administrator.testmodule.R;

/**
 * Created by wulee on 2017/6/5 16:06
 */

public class HeaderViewActivity extends AppCompatActivity {

    private ImageView diamondImageView;

    private int width= 200;
    private int height= 200;

    private Xfermode mXfermode;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.hederview);

        diamondImageView = (ImageView) findViewById(R.id.diamond_header);

        mXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);

        doDrawPath();
    }


    //绘制路径: 绘制一个菱形
    private void doDrawPath(){
        Bitmap bm = Bitmap.createBitmap(width,height,Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bm);
        canvas.drawColor(Color.parseColor("#00ff00"));

        Paint paint = new Paint();
        paint.setColor(Color.RED);
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

        paint.setColor(Color.YELLOW);
        //按路径绘制，就是一个菱形
        canvas.drawPath(path,paint);

        paint.setColor(Color.WHITE);
        paint.setXfermode(mXfermode);
        canvas.drawCircle(width/2,width/2,width/2+10,paint);

        diamondImageView.setImageBitmap(bm);
    }

}
