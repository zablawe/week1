package com.bawei.zhangjiafu1707b20191225.app;

import android.app.Application;
import android.content.Context;

import com.bawei.zhangjiafu1707b20191225.mvp.contract.Contract;
import com.bawei.zhangjiafu1707b20191225.utils.MyHoder;

/**
 * @author: 张家辅
 * @date: 2019/12/25
 */
public class App extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
        MyHoder myHoder = new MyHoder();
        Thread.setDefaultUncaughtExceptionHandler(myHoder);
    }

    public static Context getContext() {
        return context;
    }
}
