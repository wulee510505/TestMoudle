package com.wulee.administrator.testmodule.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wulee on 2016/5/13.
 */
public class VerticalScrollTextView extends TextView {

    private float step = 0f;
    private Paint mPaint = new Paint();
    ;
    private String text;
    private float width;
    private List<String> textList = new ArrayList<String>();    //分行保存textview的显示信息。

    public VerticalScrollTextView(Context context) {
        super(context);
    }

    public VerticalScrollTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VerticalScrollTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = MeasureSpec.getSize(widthMeasureSpec);
        final int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        if (widthMode != MeasureSpec.EXACTLY) {
            throw new IllegalStateException("ScrollLayout only canmCurScreen run at EXACTLY mode!");
        }

        text = "这是一个垂直滚动的TextView";
        if (text == null | text.length() == 0) {

            return;
        }
        //下面的代码是根据宽度和字体大小，来计算textview显示的行数。

        textList.clear();
        StringBuilder builder = null;
        for (int i = 0; i < text.length(); i++) {
            if (i % 40 == 0) {
                builder = new StringBuilder();
            }
            if (i % 40 <= 11) {
                builder.append(text.charAt(i));
            }
            if (i % 40 == 11) {
                textList.add(builder.toString());
            }

        }
        Log.e("textviewscroll", "" + textList.size());


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(textList.size()==0)  return;

        mPaint.setTextSize(30f);//设置字体大小
        for(int i = 0; i < textList.size(); i++) {
            canvas.drawText(textList.get(i), 0, this.getHeight()+(i+1)*mPaint.getTextSize()-step, mPaint);
        }
        invalidate();

        step = step+0.3f;
        if (step >= this.getHeight()+textList.size()*mPaint.getTextSize()) {
            step = 0;
        }
    }

}
