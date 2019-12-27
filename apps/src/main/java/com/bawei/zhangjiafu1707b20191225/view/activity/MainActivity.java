package com.bawei.zhangjiafu1707b20191225.view.activity;



import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.RadioGroup;

import com.bawei.zhangjiafu1707b20191225.R;
import com.bawei.zhangjiafu1707b20191225.base.BaseActivity;
import com.bawei.zhangjiafu1707b20191225.presenter.Presenter;
import com.bawei.zhangjiafu1707b20191225.view.fragment.Fragment_Find;
import com.bawei.zhangjiafu1707b20191225.view.fragment.Fragment_Login;
import com.bawei.zhangjiafu1707b20191225.view.fragment.Fragment_My;
import com.bawei.zhangjiafu1707b20191225.view.fragment.Fragment_Seek;
import com.bawei.zhangjiafu1707b20191225.view.fragment.Fragment_Sort;

import java.util.ArrayList;

public class MainActivity extends BaseActivity<Presenter> {

    private ViewPager vp;
    private RadioGroup rg;

    @Override
    protected Presenter initPresenter() {
        return new Presenter();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        vp = findViewById(R.id.vp);
        rg = findViewById(R.id.rg);
        Fragment_Login fragment_1 = new Fragment_Login();
        Fragment_Sort fragment_2 = new Fragment_Sort();
        Fragment_Find fragment_3 = new Fragment_Find();
        Fragment_Seek fragment_4 = new Fragment_Seek();
        Fragment_My fragment_5 = new Fragment_My();
        final ArrayList<Fragment> list = new ArrayList<>();
        list.add(fragment_1);
        list.add(fragment_2);
        list.add(fragment_3);
        list.add(fragment_4);
        list.add(fragment_5);
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.bt_login:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.bt_sort:
                        vp.setCurrentItem(1);
                        break;
                    case R.id.bt_find:
                        vp.setCurrentItem(2);
                        break;
                    case R.id.bt_seek:
                        vp.setCurrentItem(3);
                        break;
                    case R.id.bt_my:
                        vp.setCurrentItem(4);
                        break;


                }
            }
        });
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
            rg.check(rg.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }


    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(presenter!=null){
            presenter.detach();
        }
    }

    @Override
    public void success(Object object) {

    }


    @Override
    public void error(Throwable throwable) {

    }
}
