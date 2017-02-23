package com.wulee.administrator.testmodule.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.wulee.administrator.testmodule.utils.SystemUtils;

/**
 * Created by wulee on 2016/5/17.
 */
public class XfermodeView extends View {

    //PorterDuff模式常量 可以在此更改不同的模式测试
    private static final PorterDuff.Mode MODE = PorterDuff.Mode.ADD;
    private PorterDuffXfermode porterDuffXfermode;
    private int screenW, screenH; //屏幕宽高
    private Bitmap srcBitmap, dstBitmap;
    //源图和目标图宽高
    private int width = 240;
    private int height = 240;

    public XfermodeView(Context context) {
        this(context, null);
    }

    public XfermodeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        screenW = SystemUtils.getScreenWidthAndHeight((Activity) context)[0];
        screenH = SystemUtils.getScreenWidthAndHeight((Activity) context)[1];

        //创建一个PorterDuffXfermode对象
        porterDuffXfermode = new PorterDuffXfermode(MODE);
        //创建原图和目标图
        srcBitmap = makeSrc(width, height);
        dstBitmap = makeDst(width, height);
    }

    //创建一个圆形bitmap，作为dst图
    private Bitmap makeDst(int w, int h) {
        Bitmap bm = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bm);
        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setColor(0xFFFFCC44);
        c.drawOval(new RectF(0, 0, w * 3 / 4, h * 3 / 4), p);
        return bm;
    }

    // 创建一个矩形bitmap，作为src图
    private Bitmap makeSrc(int w, int h) {
        Bitmap bm = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bm);
        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setColor(0xFF66AAFF);
        c.drawRect(w / 3, h / 3, w * 19 / 20, h * 19 / 20, p);
        return bm;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setFilterBitmap(false);
        paint.setStyle(Paint.Style.FILL);
        //绘制“src”蓝色矩形原图
        canvas.drawBitmap(srcBitmap, screenW / 8 - width / 4, screenH / 12 - height / 4, paint);
        //绘制“dst”黄色圆形原图
        canvas.drawBitmap(dstBitmap, screenW / 2, screenH / 12, paint);

        //创建一个图层，在图层上演示图形混合后的效果
        int sc = canvas.saveLayer(0, 0, screenW, screenH, null, Canvas.MATRIX_SAVE_FLAG |
                Canvas.CLIP_SAVE_FLAG |
                Canvas.HAS_ALPHA_LAYER_SAVE_FLAG |
                Canvas.FULL_COLOR_LAYER_SAVE_FLAG |
                Canvas.CLIP_TO_LAYER_SAVE_FLAG);

        //先绘制“dst”黄色圆形
        canvas.drawBitmap(dstBitmap, screenW / 4, screenH / 3, paint);
        //设置Paint的Xfermode
        paint.setXfermode(porterDuffXfermode);
        canvas.drawBitmap(srcBitmap, screenW / 4, screenH / 3, paint);
        paint.setXfermode(null);
        // 还原画布
        canvas.restoreToCount(sc);
    }
}
