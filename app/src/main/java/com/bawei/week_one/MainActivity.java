package com.bawei.week_one;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.bawei.week_one.base.BaseActivity;
import com.bawei.week_one.frag.HomeFragment;
import com.bawei.week_one.frag.OtherFragment;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {


    private ViewPager pager;
    private RadioGroup radioGroup;
    ArrayList <Fragment> fragmentArrayList = new ArrayList <>();

    @Override
    protected void inniDate() {
        HomeFragment homeFragment = new HomeFragment();
        OtherFragment otherFragment = new OtherFragment();
        OtherFragment myFragment = new OtherFragment();


        fragmentArrayList.add( homeFragment );
        fragmentArrayList.add( otherFragment );
        fragmentArrayList.add( myFragment );
    }

    @Override
    protected void inniVIew() {
        pager = findViewById( R.id.view_pager );
        radioGroup = findViewById( R.id.radio_group );

        pager.addOnPageChangeListener( new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
               radioGroup.check( radioGroup.getChildAt( i ).getId() );
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        } );
          radioGroup.setOnCheckedChangeListener( new RadioGroup.OnCheckedChangeListener() {
              @Override
              public void onCheckedChanged(RadioGroup group, int checkedId) {
                  switch (checkedId){
                      case R.id.btn1:
                          pager.setCurrentItem( 0 );
                          break;
                      case R.id.btn2:
                          pager.setCurrentItem( 1 );
                          break;
                      case R.id.bt3:
                          pager.setCurrentItem( 2 );
                          break;
                  }
              }
          } );
    }

    @Override
    protected int inniLayout() {
        return R.layout.activity_main;
    }
}
