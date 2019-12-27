package com.bawei.week_one.model;

import com.bawei.week_one.contract.IContract;
import com.bawei.week_one.entity.DateBean;
import com.bawei.week_one.utils.VolleyUTils;
import com.bumptech.glide.load.model.Model;
import com.google.gson.Gson;

/**
 * author: 张奥
 * data: 2019-09-29
 * function:
 */
public class HomeModel implements IContract.MyModel {
    @Override
    public void getDate(String url, final ModelCallback modelCallback) {
        VolleyUTils.getInstance().doGet( url, new VolleyUTils.VollCallback() {
            @Override
            public void getSuccess(String dates) {
                DateBean dateBean = new Gson().fromJson( dates, DateBean.class );
                modelCallback.success( dateBean );
            }

            @Override
            public void getError(Throwable throwable) {
              modelCallback.error( throwable );
            }
        } );
    }
}
