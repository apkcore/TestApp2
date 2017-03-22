package com.apkcore.pathtest;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * 贝赛尔曲线
 * Created by Apkcore on 2017/3/20.
 */

public class MyPathView2 extends View {
    private Paint mPaint;
    private Path mPath;
    private PaintFlagsDrawFilter pfd;
    private int mWaveCount;

    private int offset;
    private int mScreenHeight;
    private int mScreenWidth;
    private int mWL = 1000;
    private int mCenterY;

    public MyPathView2(Context context) {
        this(context, null);
    }

    public MyPathView2(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyPathView2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        initAnimator();
    }

    private void initAnimator() {
        ValueAnimator animator = ValueAnimator.ofInt(0,mWL);
        animator.setDuration(1000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                offset = (int) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        animator.start();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.parseColor("#59c3e2"));
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setStrokeWidth(10);
        mPath = new Path(); //创建Path对象
        pfd = new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG | Paint.FILTER_BITMAP_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        mPath.moveTo(-mWL, mCenterY);
//        mPath.quadTo((-mWL * 3 / 4), mCenterY + 60, (-mWL / 2), mCenterY);
//        mPath.quadTo((-mWL / 4), mCenterY - 60, 0, mCenterY);
//        mPath.quadTo((mWL / 4), mCenterY + 60, (mWL / 2), mCenterY);
//        mPath.quadTo((mWL * 3 / 4), mCenterY - 60, mWL, mCenterY);

        mPath.reset();
        mPath.moveTo(-mWL+offset,mCenterY);
        for (int i = 0; i < mWaveCount; i++) {
            mPath.quadTo((-mWL * 3 / 4) + (i * mWL) + offset, mCenterY + 60, (-mWL / 2) + (i * mWL) + offset, mCenterY);
            mPath.quadTo((-mWL / 4) + (i * mWL) + offset, mCenterY - 60, i * mWL + offset, mCenterY);
        }
        mPath.lineTo(mScreenWidth, mScreenHeight);
        mPath.lineTo(0, mScreenHeight);
        mPath.close();

        canvas.setDrawFilter(pfd);
        canvas.drawPath(mPath, mPaint);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mScreenHeight = h;
        mScreenWidth = w;
        mWaveCount = (int) Math.round(mScreenWidth / mWL + 1.5);
        mCenterY = mScreenHeight / 2;
    }
}
