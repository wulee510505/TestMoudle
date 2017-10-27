package com.wulee.administrator.testmodule.view;

/**
 * Created by wulee on 2017/10/27 14:23
 */

public class AnimationInfo {
    float scale;
    float rotate;
    float x;
    float y;

    public AnimationInfo(float scale, float rotate, float x, float y) {
        this.scale = scale;
        this.rotate = rotate;
        this.x = x;
        this.y = y;
    }

    public float calculateTranslationX(float length) {
        return (float) Math.cos(rotate) * length + x;
    }

    public float calculateTranslationY(float length) {
        return (float) Math.sin(rotate) * length + y;
    }
}
