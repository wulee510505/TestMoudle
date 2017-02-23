package com.wulee.administrator.testmodule.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.wulee.administrator.testmodule.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by wulee on 2016/8/5 16:57
 */

public class SearchUtils {
    private Activity mActivity;
    private View searchView;
    private AutoCompleteTextView ediSearch;
    private View alphaView;
    private TextView tvCancle;
    private PopupWindow popupWindow;
    private int moveHeight;
    private int statusBarHeight;
    private View fatherView;// 界面的跟布局
    private View topTitleView;// 标题栏布局

    /**
     *
     * @param activity
     * @param rlTopTitle
     *            ,标题栏布局
     * @param llFather
     *            ,界面的跟布局
     * @param textWatcher
     *            ，文本框监听
     * @param strHint
     *            ,搜索框的提示语
     */
    public SearchUtils(Activity activity, View rlTopTitle, final View llFather,
                       String strHint, TextWatcher textWatcher) {
        super();
        this.mActivity = activity;
        this.topTitleView = rlTopTitle;
        this.fatherView = llFather;
        initViews(strHint);
        initListener(textWatcher);
    }

    private void initListener(TextWatcher textWatcher) {
        // TODO Auto-generated method stub
        alphaView.setOnClickListener(onClick);
        tvCancle.setOnClickListener(onClick);
        ediSearch.addTextChangedListener(textWatcher);
    }

    private void initViews(String strHint) {
        LayoutInflater mInflater = LayoutInflater.from(mActivity);
        searchView = mInflater.inflate(R.layout.search, null);

        ediSearch = (AutoCompleteTextView) searchView
                .findViewById(R.id.edi_search);
        ediSearch.setHint(strHint);
        ediSearch.setFocusable(true);
        alphaView = searchView.findViewById(R.id.popup_window_v_alpha);
        tvCancle = (TextView) searchView.findViewById(R.id.tvCanale);

        popupWindow = new PopupWindow(searchView, LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setTouchable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
    }

    public void showSearchBar() {
        getStatusBarHeight();
        moveHeight = topTitleView.getHeight();
        Animation translateAnimation = new TranslateAnimation(0, 0, 0,
                -moveHeight);
        translateAnimation.setDuration(300);
        fatherView.startAnimation(translateAnimation);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation arg0) {
            }

            @Override
            public void onAnimationRepeat(Animation arg0) {

            }

            @Override
            public void onAnimationEnd(Animation arg0) {
                TranslateAnimation anim = new TranslateAnimation(0, 0, 0, 0);
                fatherView.setAnimation(anim);
                topTitleView.setVisibility(View.GONE);
                topTitleView.setPadding(0, -moveHeight, 0, 0);

                popupWindow.showAtLocation(fatherView, Gravity.CLIP_VERTICAL,
                        0, statusBarHeight);
                openKeyboard();
            }
        });
    }

    View.OnClickListener onClick = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            switch (v.getId()) {
                case R.id.popup_window_v_alpha:
                    dismissPopupWindow();
                    break;
                case R.id.tvCanale:
                    dismissPopupWindow();
                    break;
            }
        }
    };

    private void dismissPopupWindow() {
        if (popupWindow != null && popupWindow.isShowing()) {
            popupWindow.dismiss();
            resetUI();
        }
    }

    private void getStatusBarHeight() {
        Rect frame = new Rect();
        mActivity.getWindow().getDecorView()
                .getWindowVisibleDisplayFrame(frame);// 这里得到的是除了系统自带显示区域之外的所有区域，这里就是除了最上面的一条显示电量的状态栏之外的所有区域
        statusBarHeight = frame.top; // 这里便可以得到状态栏的高度，即最上面一条显示电量，信号等

    }

    /**
     * 展开键盘
     */
    private void openKeyboard() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                InputMethodManager imm = (InputMethodManager) mActivity
                        .getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }, 0);
    }

    private void resetUI() {
        topTitleView.setPadding(0, 0, 0, 0);
        topTitleView.setVisibility(View.VISIBLE);
        Animation translateAnimation = new TranslateAnimation(0, 0,
                -moveHeight, 0);
        translateAnimation.setDuration(300);
        fatherView.startAnimation(translateAnimation);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation arg0) {

            }

            @Override
            public void onAnimationRepeat(Animation arg0) {

            }

            @Override
            public void onAnimationEnd(Animation arg0) {
                TranslateAnimation anim = new TranslateAnimation(0, 0, 0, 0);
                fatherView.setAnimation(anim);
            }
        });
    }
}
