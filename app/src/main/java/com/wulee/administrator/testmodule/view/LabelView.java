package com.wulee.administrator.testmodule.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wulee.administrator.testmodule.R;
import com.wulee.administrator.testmodule.utils.SystemUtils;

import static com.wulee.administrator.testmodule.R.styleable.LabelView_lable_text_bg_color;
import static com.wulee.administrator.testmodule.R.styleable.LabelView_lable_text_color;
import static com.wulee.administrator.testmodule.R.styleable.LabelView_lable_text_size;

/**
 * Created by wulee on 2016/10/14 15:04
 */

public class LabelView extends RelativeLayout {

    private TextView mTextView;
    private ImageView mImageView;

    private String btntext;
    private int lableTextColor;
    private int lableTextBgColor;
    private float lableTextSize;
    private int delbtnVisibility;

    public LabelView(Context context) {
        super(context);
    }

    public LabelView(Context context, AttributeSet attrs) {
        super(context, attrs);

        //加载视图的布局
        LayoutInflater.from(context).inflate(R.layout.lableview_layout,this,true);
        //加载自定义的属性
        TypedArray a=context.obtainStyledAttributes(attrs,R.styleable.LabelView);
        btntext=a.getString(R.styleable.LabelView_lable_text);
        lableTextColor=a.getColor(LabelView_lable_text_color, Color.BLACK);
        lableTextBgColor=a.getColor(LabelView_lable_text_bg_color, Color.parseColor("#cdcdcd"));
        lableTextSize= SystemUtils.px2sp(a.getDimensionPixelSize(LabelView_lable_text_size, 14),context);
        delbtnVisibility = a.getInt(R.styleable.LabelView_del_btn_visibility, 1);

        a.recycle();
    }

    /**
     * 此方法会在所有的控件都从xml文件中加载完成后调用
     */
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        //获取子控件
        mTextView= (TextView) findViewById(R.id.lable_text);
        mImageView= (ImageView) findViewById(R.id.del_iv);

        //将从资源文件中加载的属性设置给子控件
        if (!TextUtils.isEmpty(btntext))
            setLableText(btntext);
        setLableTextColor(lableTextColor);
        setLableTextBgColor(lableTextBgColor);
        setLableTextSize(lableTextSize);
        setDelBtnVisibility(delbtnVisibility);
    }

    /**
     * 设置标签文字
     * @param text
     */
    public void setLableText(String text) {
        mTextView.setText(text);
    }

    /**
     * 设置标签文字颜色
     * @param color
     */
    public void setLableTextColor(int color) {
        mTextView.setTextColor(color);
    }

    /**
     * 设置标签文字背景颜色
     * @param color
     */
    public void setLableTextBgColor(int color) {
        mTextView.setBackgroundColor(color);
    }

    /**
     * 设置标签文字大小
     * @param size
     */
    public void setLableTextSize(float size) {
        mTextView.setTextSize(size);
    }

    /**
     * 设置删除按钮显示/隐藏
     * @param visibility
     */
    public void setDelBtnVisibility(int visibility) {
        if(visibility == 0){
            mImageView.setVisibility(View.GONE);
        } else if(visibility == 1){
            mImageView.setVisibility(View.VISIBLE);
        }
    }

    public String getLableText(){
        return mTextView.getText().toString();
    }

    /**
     * 设置标签点击事件监听器
     * @param listener
     */
    public void setOnLableTextClickListener(OnClickListener listener) {
        mTextView.setOnClickListener(listener);
    }

    /**
     * 设置删除按钮点击事件监听器
     * @param listener
     */
    public void setOnDelBtnClickListener(OnClickListener listener) {
        mImageView.setOnClickListener(listener);
    }

}
