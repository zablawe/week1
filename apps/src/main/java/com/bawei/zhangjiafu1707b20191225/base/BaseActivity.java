package com.bawei.zhangjiafu1707b20191225.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;



import com.bawei.zhangjiafu1707b20191225.mvp.BasePresenter;
import com.bawei.zhangjiafu1707b20191225.mvp.contract.Contract;

/**
 * @author: 张家辅
 * @date: 2019/12/25
 */
public abstract class BaseActivity<P extends BasePresenter>extends AppCompatActivity implements Contract.IView {
   public P presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        presenter=initPresenter();
        presenter.attach(this);
        initView();
        initData();
    }

    protected abstract P initPresenter();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int layoutId();
}
