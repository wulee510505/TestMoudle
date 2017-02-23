package com.wulee.administrator.testmodule.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wulee.administrator.testmodule.R;
import com.wulee.administrator.testmodule.utils.SystemUtils;

/**
 * Created by wulee on 2016/5/10.
 */
public class YearSelectView extends RelativeLayout {


    private Button btnLeft,btnRight;
    private TextView tvMiddle;

    private Drawable bgBtnPreRes,bgBtnNextRes;


    private  int middTextSize;
    private  int middleTextColor;
    private  Drawable middTextBgColor;

    private  String midddleText;


    private RelativeLayout.LayoutParams btnLeftParams,btnRightParams,tvMiddleleParams;

    private  OnBtnClickListener mListener;
    private  Context mContext;

    public  interface OnBtnClickListener{
        void onLeftBtnClick();
        void onRightBtnClick();
    }

    public  void setBtnClickListener(OnBtnClickListener listener){
        this.mListener = listener;
    }

    public YearSelectView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.YearSelectView);
        bgBtnPreRes  = ta.getDrawable(R.styleable.YearSelectView_leftBtnBg);
        bgBtnNextRes  = ta.getDrawable(R.styleable.YearSelectView_rightBtnBg);
        middTextSize = ta.getDimensionPixelSize(R.styleable.YearSelectView_android_textSize, 16);
        middleTextColor = ta.getColor(R.styleable.YearSelectView_middleTextColor, getResources().getColor(R.color.default_badge_text_color));
        midddleText  = ta.getString(R.styleable.YearSelectView_middleText);
        middTextBgColor = ta.getDrawable(R.styleable.YearSelectView_middleTextBgColor);

        btnLeft = new Button(context);
        btnRight = new Button(context);
        tvMiddle  = new TextView(context);

        btnLeft.setBackgroundDrawable(bgBtnPreRes);
        btnRight.setBackgroundDrawable(bgBtnNextRes);

        tvMiddle.setTextColor(middleTextColor);
        float middTextsize = SystemUtils.px2sp(middTextSize,context);
        tvMiddle.setTextSize(TypedValue.COMPLEX_UNIT_SP,middTextsize);
        tvMiddle.setText(midddleText);
        tvMiddle.setBackgroundDrawable(middTextBgColor);

        ta.recycle();

        int leftBtnId = 100;
        int rightBtnId = 200;

        btnLeft.setId(leftBtnId);
        btnRight.setId(rightBtnId);

        btnLeftParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        btnLeftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);

        addView(btnLeft, btnLeftParams);


        btnRightParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        btnRightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
        addView(btnRight, btnRightParams);

        tvMiddleleParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT);
        tvMiddleleParams.addRule(RelativeLayout.CENTER_IN_PARENT,RelativeLayout.TRUE);
        tvMiddleleParams.addRule(RelativeLayout.RIGHT_OF,leftBtnId);
        tvMiddleleParams.addRule(RelativeLayout.LEFT_OF,rightBtnId);
        tvMiddle.setGravity(Gravity.CENTER);
        tvMiddleleParams.rightMargin = 20;
        tvMiddleleParams.leftMargin = 20;
        tvMiddle.setPadding(0,0,0,0);
        addView(tvMiddle, tvMiddleleParams);

        btnLeft.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onLeftBtnClick();
            }
        });
        btnRight.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onRightBtnClick();
            }
        });

    }


    public void  setMiddleText(String text){
        tvMiddle.setText(text);
    }

}
