package com.bawei.week_one.contract;

import com.bawei.week_one.entity.DateBean;

/**
 * author: 张奥
 * data: 2019-09-29
 * function:
 */
public interface IContract {
    public interface MyModel{
        void  getDate(String url ,ModelCallback modelCallback);
        interface ModelCallback{
            void success(DateBean dateBean);
            void error(Throwable throwable);
        }
    }

    interface MyView{
        void success(DateBean dateBean);
        void error(Throwable throwable);
    }

    interface MyPresenter{
        void  getDate(String url);
    }
}
