package com.bawei.zhangjiafu1707b20191225.utils;

import android.support.annotation.NonNull;
import android.widget.Toast;


import com.bawei.zhangjiafu1707b20191225.app.App;

/**
 * @author: 张家辅
 * @date: 2019/12/25
 */
public class MyHoder implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(@NonNull Thread t, @NonNull Throwable e) {
        Toast.makeText(App.getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
