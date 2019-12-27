package com.bawei.zhangjiafu1707b20191225.view.fragment;

import android.view.View;

import com.bawei.zhangjiafu1707b20191225.R;
import com.bawei.zhangjiafu1707b20191225.base.BaseFragment;
import com.bawei.zhangjiafu1707b20191225.presenter.Presenter;

/**
 * @author: 张家辅
 * @date: 2019/12/25
 */
public class Fragment_Sort extends BaseFragment<Presenter> {
    @Override
    protected Presenter initPresenter() {
        return new Presenter();
    }

    @Override
    protected void initView(View inflate) {

    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_sort;
    }

    @Override
    protected void initData() {

    }


    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void success(Object object) {

    }


    @Override
    public void error(Throwable throwable) {

    }
}
