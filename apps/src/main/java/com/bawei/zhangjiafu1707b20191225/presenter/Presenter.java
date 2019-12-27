package com.bawei.zhangjiafu1707b20191225.presenter;

import com.bawei.zhangjiafu1707b20191225.model.Model;
import com.bawei.zhangjiafu1707b20191225.mvp.BasePresenter;
import com.bawei.zhangjiafu1707b20191225.mvp.contract.Contract;

/**
 * @author: 张家辅
 * @date: 2019/12/25
 */
public class Presenter extends BasePresenter<Model, Contract.IView> implements Contract.IPresenter {
    @Override
    protected Model initModel() {
        return new Model();
    }


    @Override
    public void Flowsuccess(String string) {
     model.Flowsuccess(string, new Contract.IModel.CallBack() {
         @Override
         public void success(Object object) {
             getView().success(object);
         }

         @Override
         public void error(Throwable object) {
            getView().error(object);
         }
     });
    }

    @Override
    public void Listsuccess(String string) {
        model.Listsuccess(string, new Contract.IModel.CallBack() {
            @Override
            public void success(Object object) {
                getView().success(object);
            }

            @Override
            public void error(Throwable object) {
                getView().error(object);
            }
        });
    }

    @Override
    public void error(Throwable throwable) {

    }
}
