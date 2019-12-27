package com.bawei.zhangjiafu1707b20191225.mvp.contract;

import com.bawei.zhangjiafu1707b20191225.mvp.IBaseModel;
import com.bawei.zhangjiafu1707b20191225.mvp.IBaseView;

/**
 * @author: 张家辅
 * @date: 2019/12/25
 */
public class Contract {
    //ii.（核心）MVP分包明确、逻辑清晰、使用契约
 public  interface IView extends IBaseView {
        void success(Object object);
        void error(Throwable throwable);
    }
    public  interface IPresenter{
        void Flowsuccess(String string);
        void Listsuccess(String string);
        void error(Throwable throwable);
    }
    public  interface IModel extends IBaseModel {
        void Flowsuccess(String string,CallBack callBack);
        void Listsuccess(String string,CallBack callBack);
        void error(Throwable throwable);
       interface CallBack{
           void success(Object object);
           void error(Throwable throwable);
       }
    }
}
