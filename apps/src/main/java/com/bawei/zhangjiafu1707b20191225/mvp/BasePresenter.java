package com.bawei.zhangjiafu1707b20191225.mvp;

import java.lang.ref.WeakReference;

/**
 * @author: 张家辅
 * @date: 2019/12/25
 */
public abstract class BasePresenter<M extends IBaseModel,V extends IBaseView> {
    //i.（熟练掌握）封装Activity基类与Fragment基类，在Activity基类中抽取初始化Presenter的方法
    public M model;
    private WeakReference<V> weakReference;

    public BasePresenter() {
        model=initModel();
    }
    public void attach(V v){
        weakReference=new WeakReference<V>(v);
    }
    //iii.（熟练掌握）解决MVP内存泄漏
    public void detach(){
        weakReference.clear();
    }
    public V getView(){
        return weakReference.get();
    }

    protected abstract M initModel();
}
