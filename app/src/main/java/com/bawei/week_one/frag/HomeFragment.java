package com.bawei.week_one.frag;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.week_one.R;
import com.bawei.week_one.adapter.MyAdapter;
import com.bawei.week_one.base.BaseFragment;
import com.bawei.week_one.contract.IContract;
import com.bawei.week_one.entity.DateBean;
import com.bawei.week_one.presenter.HomePresenter;

import java.util.List;

public class HomeFragment extends BaseFragment implements IContract.MyView {

    private RecyclerView recyclerView;

    @Override
    protected int inniLayout() {
        return R.layout.fragment_home;

    }

    @Override
    protected void inniView(View view) {
        recyclerView = view.findViewById( R.id.recycler_view );
        recyclerView.setLayoutManager( new GridLayoutManager( getActivity(),2 ) );

    }

    @Override
    protected void inniDate(Bundle savedInstanceState) {

    }

    @Override
    public void success(DateBean dateBean) {
        List <DateBean.ResultBean> result = dateBean.getResult();
        recyclerView.setAdapter( new MyAdapter(result) );
    }

    @Override
    public void error(Throwable throwable) {

    }
}
