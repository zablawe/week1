package com.bawei.week_one.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * author: 张奥
 * data: 2019-09-29
 * function:
 */
public class FlowLayout extends ViewGroup {
    public FlowLayout(Context context) {
        super( context );
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super( context, attrs );
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super( context, attrs, defStyleAttr );
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}
