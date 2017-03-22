package com.apkcore.pathtest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * path 类的使用
 * Created by Apkcore on 2017/3/20.
 */

public class MyView extends View {
    private Paint mPaint;
    private Path mPath;

    public MyView(Context context) {
        this(context, null);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);
        mPath = new Path(); //创建Path对象
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /**
         * 线的操作
         */
        mPath.moveTo(100, 100);
        mPath.lineTo(300, 300);
        mPath.lineTo(100, 300);
        mPath.lineTo(100, 100);
        mPath.moveTo(300, 300);
        mPath.lineTo(500, 300);
        mPath.setLastPoint(500, 500);//改变上一次操作路径的结束坐标点
        mPath.lineTo(100, 500);
        mPath.close();

        /**
         *  基本形状
         */
        RectF rectF = new RectF(100,800,200,900);
        mPath.addRect(rectF, Path.Direction.CW);
        mPath.setLastPoint(150,1000);

        mPath.addCircle(500,1000,200, Path.Direction.CW);

        rectF = new RectF(100,1200,500,1700);
        mPath.addRoundRect(rectF,100,100, Path.Direction.CW);//圆角的两个半径


        canvas.drawPath(mPath, mPaint);//画出路径
    }
}
