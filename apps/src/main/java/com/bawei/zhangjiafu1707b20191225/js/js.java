package com.bawei.zhangjiafu1707b20191225.js;

import android.webkit.JavascriptInterface;
import android.widget.Toast;

import com.bawei.zhangjiafu1707b20191225.app.App;

/**
 * @author: 张家辅
 * @date: 2019/12/25
 */
public class js {
    @JavascriptInterface
    public void share(){
        Toast.makeText(App.getContext(), "分享成功", Toast.LENGTH_SHORT).show();
    }
}
