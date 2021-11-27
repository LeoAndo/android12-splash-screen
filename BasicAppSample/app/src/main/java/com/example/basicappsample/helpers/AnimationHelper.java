package com.example.basicappsample.helpers;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

import androidx.transition.TransitionManager;

import com.google.android.material.transition.MaterialFade;

public final class AnimationHelper {
    private AnimationHelper() {
    }

    /**
     * 点滅アニメーションを行う.
     *
     * @param view アニメーションを適用させるView
     */
    public static void startAlphaAnimation(View view) {
        final float fromAlpha = 0.0f, toAlpha = 1.0f;
        final long durationMillis = 800, startOffset = 1000;
        Animation animation = new AlphaAnimation(fromAlpha, toAlpha);
        animation.setDuration(durationMillis);
        animation.setStartOffset(startOffset);
        animation.setRepeatMode(Animation.REVERSE);
        animation.setRepeatCount(Animation.INFINITE);
        view.startAnimation(animation);
    }

    /**
     * Fade In / Fade outアニメーションを行う
     *
     * @param isVisible true: 表示 false: 非表示
     * @param vg ConstraintLayoutやLinearLayoutなどのレイアウトクラスのインスタンス
     * @param targetView アニメーションを適用させるView
     */
    public static void startFadeAnimation(boolean isVisible, ViewGroup vg, View targetView) {
        MaterialFade fade = new MaterialFade();
        fade.setDuration(500L);
        TransitionManager.beginDelayedTransition(vg, fade);
        int visibility = (isVisible) ? View.VISIBLE : View.INVISIBLE;
        targetView.setVisibility(visibility);
    }
}
