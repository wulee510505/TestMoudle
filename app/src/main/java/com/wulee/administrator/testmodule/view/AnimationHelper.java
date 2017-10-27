package com.wulee.administrator.testmodule.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;

/**
 * Created by wulee on 2017/10/27 14:10
 */

public class AnimationHelper {
    public static void start(View view) {
        ViewGroup suitableParent = findSuitableParent(view);
        FaceView child = new FaceView(view.getContext());
        suitableParent.addView(child);
    }

    private static ViewGroup findSuitableParent(View view) {
        ViewGroup fallback = null;
        do {
            if (view instanceof FrameLayout) {
                if (view.getId() == android.R.id.content) {
                    return (ViewGroup) view;
                } else {
                    fallback = (ViewGroup) view;
                }
            }
            if (view != null) {
                final ViewParent parent = view.getParent();
                view = parent instanceof View ? (View) parent : null;
            }
        } while (view != null);
        return fallback;
    }
}
