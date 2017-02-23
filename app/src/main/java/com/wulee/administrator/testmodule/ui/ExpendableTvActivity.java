package com.wulee.administrator.testmodule.ui;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ImageSpan;
import android.view.Gravity;
import android.view.ViewTreeObserver;
import android.widget.TextView;

import com.wulee.administrator.testmodule.R;
import com.wulee.administrator.testmodule.view.ExpandableTextView;

/**
 * Created by wulee on 2016/3/31.
 */
public class ExpendableTvActivity extends Activity {


    private ExpandableTextView expandable_tv;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expandable_textview);

        expandable_tv = (ExpandableTextView) findViewById(R.id.expandable_tv);
        tv  = (TextView) findViewById(R.id.tv);

        expandable_tv.setTrimLength(60);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<20;i++){
            sb.append("可收缩展开的TextView");
        }
        expandable_tv.setText(sb.toString());

        sb = new StringBuilder();
        for(int i=0;i<20;i++){
            sb.append("图文混排的TextView");
        }
        toggleEllipsize(tv,sb.toString());
    }




    private void toggleEllipsize(final TextView tv,final String desc){
        if(desc == null){
            return;
        }
        tv.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                boolean isEllipsized = (tv.getTag() == null || tv.getTag().equals(false)) ? false : (Boolean) tv.getTag();
                if (isEllipsized) {
                    tv.setTag(false);
                    tv.setText(desc);
                } else {
                    tv.setTag(true);
                    int paddingLeft = tv.getPaddingLeft();
                    int paddingRight = tv.getPaddingRight();
                    TextPaint paint = tv.getPaint();
                    float moreText = tv.getTextSize() * 3;
                    float availableTextWidth = (tv.getWidth() - paddingLeft - paddingRight) * 2 - moreText;

                    CharSequence ellipsizeStr = TextUtils.ellipsize(desc, paint, availableTextWidth, TextUtils.TruncateAt.END);
                    if (ellipsizeStr.length() < desc.length()) {
                        CharSequence temp = ellipsizeStr + ".";
                        SpannableStringBuilder ssb = new SpannableStringBuilder(temp);
                        Drawable dd = getResources().getDrawable(R.drawable.game_info_lookmore);
                        dd.setBounds(10, 10, dd.getIntrinsicWidth(), dd.getIntrinsicHeight());
                        ImageSpan is = new ImageSpan(dd, Gravity.CENTER_VERTICAL);
                        ssb.setSpan(is, temp.length() - 1, temp.length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);

                        tv.setText(ssb);
                        tv.setMovementMethod(LinkMovementMethod.getInstance());
                    } else {
                        tv.setText(desc);
                    }
                }
                if (Build.VERSION.SDK_INT >= 16) {
                    tv.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                } else {
                    tv.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
            }
        });
    }
}
