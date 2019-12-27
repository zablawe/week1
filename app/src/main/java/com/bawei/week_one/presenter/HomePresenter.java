package com.bawei.week_one.presenter;

import com.bawei.week_one.contract.IContract;
import com.bawei.week_one.entity.DateBean;
import com.bawei.week_one.model.HomeModel;

/**
 * author: 张奥
 * data: 2019-09-29
 * function:
 */
public class HomePresenter implements IContract.MyPresenter {
    private IContract.MyView myView;
    private  HomeModel homeModel;

    public HomePresenter(IContract.MyView myView) {
        this.myView = myView;
        homeModel = new HomeModel();
    }

    @Override
    public void getDate(String url) {
        homeModel.getDate( url, new IContract.MyModel.ModelCallback() {
            @Override
            public void success(DateBean dateBean) {
                myView.success( dateBean );
            }

            @Override
            public void error(Throwable throwable) {
               myView.error( throwable );
            }
        } );
    }
}
