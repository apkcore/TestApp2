package com.apkcore.testapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 画浮在上面的tag
 */

public class LeftAndRightTagDecoration extends RecyclerView.ItemDecoration {
    private int tagWidth;
    private Paint leftPaint;
    private Paint rightPaint;

    public LeftAndRightTagDecoration(Context context) {
        leftPaint = new Paint();
        rightPaint = new Paint();
        leftPaint.setColor(ContextCompat.getColor(context, R.color.colorAccent));
        rightPaint.setColor(ContextCompat.getColor(context, R.color.colorPrimary));
        tagWidth = context.getResources().getDimensionPixelOffset(R.dimen.tag_width);
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            int pos = parent.getChildAdapterPosition(child);
            boolean isLeft = pos % 2 == 0;
            if (!isLeft) {
                float left = child.getLeft();
                float right = left + tagWidth;
                float top = child.getTop();
                float bootom = child.getBottom();
                c.drawRect(left, top, right, bootom, leftPaint);
            } else {
                float right = child.getRight();
                float left = right - tagWidth;
                float top = child.getTop();
                float bootom = child.getBottom();
                c.drawRect(left, top, right, bootom, rightPaint);
            }
        }
    }
}
