package com.apkcore.miclock;

import android.content.Context;
import android.util.Log;
import android.util.TypedValue;

/**
 * dp，px,sp之间的转换
 * Created by Apkcore on 2017/3/1.
 */

public class DensityUtils {
    private DensityUtils() {
        throw new UnsupportedOperationException("不能构建默认构造器");

    }

    public static int dp2px(Context context, float dpVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpVal, context.getResources().getDisplayMetrics());
    }

    public static int sp2dp(Context context, float spVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, spVal, context.getResources().getDisplayMetrics());
    }

    public static int sp2px(Context context, float spVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                spVal, context.getResources().getDisplayMetrics());
    }

    public static float px2dp(Context context, float pxVal) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (pxVal / scale);
    }

    public static float px2sp(Context context, float pxVal) {
        return (pxVal / context.getResources().getDisplayMetrics().scaledDensity);
    }

    static class MyTask implements Runnable {
        private int flag;
        private Object obj1 = "1";
        private Object obj2 = "2";

        @Override
        public void run() {
            if (flag == 1) {
                synchronized (obj1) {
                    Log.d("bsb3", "11111111111111");
                    synchronized (obj2) {
                        Log.d("bsb3", "22222222222222222");
                    }
                }
            } else if (flag == 2) {
                synchronized (obj2) {
                    Log.d("bsb3", "2222222222222222");
                    synchronized (obj1) {
                        Log.d("bsb3", "1111111111111111");
                    }
                }
            }
        }
    }
}
