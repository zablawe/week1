package com.bawei.zhangjiafu1707b20191225.view.fragment;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



import com.bawei.zhangjiafu1707b20191225.view.activity.InfoActivity;
import com.bawei.zhangjiafu1707b20191225.R;
import com.bawei.zhangjiafu1707b20191225.adapter.MyRecyclerAdapter;
import com.bawei.zhangjiafu1707b20191225.base.BaseFragment;
import com.bawei.zhangjiafu1707b20191225.diwgets.FlowLayout;
import com.bawei.zhangjiafu1707b20191225.entity.FlowEntity;
import com.bawei.zhangjiafu1707b20191225.entity.ListEntity;
import com.bawei.zhangjiafu1707b20191225.presenter.Presenter;

import java.net.URLEncoder;
import java.util.List;

public class Fragment_Login extends BaseFragment<Presenter> {

    private Button login_seek;
    private EditText login_goods;
    private FlowLayout flow;
    private RecyclerView rv;

    @Override
    protected Presenter initPresenter() {
        return new Presenter();
    }

    @Override
    protected void initView(View inflate) {
        login_goods = inflate.findViewById(R.id.login_goods);
        login_seek = inflate.findViewById(R.id.login_seek);
        flow = inflate.findViewById(R.id.flow);
        rv = inflate.findViewById(R.id.rv);
        rv.setLayoutManager(new StaggeredGridLayoutManager(2,RecyclerView.VERTICAL));
        login_seek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = login_goods.getText().toString();
                flow.addText(s);
                presenter.Listsuccess("http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?keyword="+URLEncoder.encode(s)+"&page=1&count=5");
            }
        });
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_login;
    }

    @Override
    protected void initData() {
      presenter.Flowsuccess("http://blog.zhaoliang5156.cn/baweiapi/"+ URLEncoder.encode("手机"));
    }


    @Override
    public void success(Object object) {
     if(object instanceof FlowEntity){
         //a)（核心）请求接口1的数据在流式布局中展示出来
         FlowEntity flowEntity=(FlowEntity)object;
         List<String> tags = flowEntity.getTags();
         flow.addlist(tags);
     }else if(object instanceof ListEntity){
         ListEntity listEntity=(ListEntity)object;
         List<ListEntity.ResultBean> result = listEntity.getResult();
         MyRecyclerAdapter myRecyclerAdapter = new MyRecyclerAdapter(getContext(), result);
         //给RecycleView设置点击事件，点击跳转到图2
         myRecyclerAdapter.setCallBack(new MyRecyclerAdapter.CallBack() {
             @Override
             public void success() {
                 Intent intent = new Intent(getContext(), InfoActivity.class);
                 startActivity(intent);
             }
         });
         rv.setAdapter(myRecyclerAdapter);
     }
    }

    @Override
    public void error(Throwable throwable) {

    }


    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }
}
