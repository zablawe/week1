package com.bawei.zhangjiafu1707b20191225.model;

import android.util.Log;

import com.bawei.zhangjiafu1707b20191225.entity.FlowEntity;
import com.bawei.zhangjiafu1707b20191225.entity.ListEntity;
import com.bawei.zhangjiafu1707b20191225.mvp.contract.Contract;
import com.bawei.zhangjiafu1707b20191225.utils.VolleyUtils;
import com.google.gson.Gson;

/**
 * @author: 张家辅
 * @date: 2019/12/25
 */
public class Model implements Contract.IModel {

    @Override
    public void Flowsuccess(String string, final CallBack callBack) {
        VolleyUtils.getInstance().doGet(string, new VolleyUtils.CallBack() {
            @Override
            public void success(String string) {
                Gson gson = new Gson();
                FlowEntity flowEntity = gson.fromJson(string, FlowEntity.class);
                callBack.success(flowEntity);
            }

            @Override
            public void error(Throwable throwable) {
            callBack.error(throwable);
            }
        });
    }

    @Override
    public void Listsuccess(String string, final CallBack callBack) {
        VolleyUtils.getInstance().doGet(string, new VolleyUtils.CallBack() {
            @Override
            public void success(String string) {
                Gson gson = new Gson();
                ListEntity listEntity = gson.fromJson(string, ListEntity.class);
                callBack.success(listEntity);
            }

            @Override
            public void error(Throwable throwable) {
                callBack.error(throwable);
            }
        });
    }

    @Override
    public void error(Throwable throwable) {

    }
}
