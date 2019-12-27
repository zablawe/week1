package com.bawei.zhangjiafu1707b20191225.view.activity;

import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.zhangjiafu1707b20191225.R;
import com.bawei.zhangjiafu1707b20191225.base.BaseActivity;
import com.bawei.zhangjiafu1707b20191225.js.js;
import com.bawei.zhangjiafu1707b20191225.presenter.Presenter;
import com.bumptech.glide.util.Util;

public class InfoActivity extends BaseActivity<Presenter> {

    private EditText info_et;
    private Button info_bt;
    private WebView web;

    @Override
    protected Presenter initPresenter() {
        return new Presenter();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        //i.（核心）展示素材提供的info.html，完成图2页面
        info_bt = findViewById(R.id.info_bt);
        info_et = findViewById(R.id.info_et);
        web = findViewById(R.id.web);
        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl("file:///android_asset/info.html");
       // iii.（核心）点击立即分享的时候调用android的share方法，在方法中输出分享。
        web.addJavascriptInterface(new js(),"android");
        web.setWebViewClient(new WebViewClient());
        //ii.（核心）在页面上点击修改介绍按钮的时候，调用js的changeInfo方法，把输入框中的输入的信息传递给js的changeInfo方法。
        info_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = info_et.getText().toString();
                web.loadUrl("JavaScript:changeInfo('"+s+"')");
            }
        });
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_info;
    }

    @Override
    public void success(Object object) {

    }

    @Override
    public void error(Throwable throwable) {

    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }
}
