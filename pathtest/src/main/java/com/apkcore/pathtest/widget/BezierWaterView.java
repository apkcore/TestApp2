package com.apkcore.pathtest.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

/**
 * 绘制心形
 * Created by Apkcore on 2017/3/23.
 */

public class BezierWaterView extends View {

    private Path mPath;
    private float mInterpolatedTime;

    public BezierWaterView(Context context) {
        this(context, null, 0);
    }

    public BezierWaterView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BezierWaterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        startAnimation();
    }

    private void init() {
        mPath = new Path();

    }

    class VPoint{
        public float x;
        public float y;
        public PointF top = new PointF();
        public PointF bottom = new PointF();

        public void setX(float x) {
            this.x = x;
            top.x = x;
            bottom.x = x;
        }

        public void addJustY(float offset){
            top.y -= offset;
            bottom.y+=offset;
        }
    }
    public void startAnimation() {
        mPath.reset();
        mInterpolatedTime = 0;
        ValueAnimator animator = ValueAnimator.ofFloat(0, 1.0f);
        animator.setDuration(2000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mInterpolatedTime = (float) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        animator.start();
    }
}
