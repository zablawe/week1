package com.bawei.zhangjiafu1707b20191225.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import com.bawei.zhangjiafu1707b20191225.mvp.BasePresenter;
import com.bawei.zhangjiafu1707b20191225.mvp.contract.Contract;

/**
 * @author: 张家辅
 * @date: 2019/12/25
 */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements Contract.IView {
   public P presenter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(layoutId(), container, false);
        initView(inflate);
        presenter=initPresenter();
        presenter.attach(this);
        return inflate;
    }

    protected abstract P initPresenter();

    protected abstract void initView(View inflate);

    protected abstract int layoutId();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    protected abstract void initData();
}
