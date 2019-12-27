package com.bawei.zhangjiafu1707b20191225.diwgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.bawei.zhangjiafu1707b20191225.app.App;

import java.util.List;

/**
 * @author: 张家辅
 * @date: 2019/12/25
 */
public class FlowLayout extends ViewGroup {
    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
  //  a)（核心）请求接口1的数据在流式布局中展示出来
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //初始化变量
        int left=0;
        int top=0;
        int rigth=0;
        int bootom=0;
        //获得子控件的数量
        int childCount = getChildCount();
        //判断有没有子控件
        if(childCount>0){
            //循环遍历
            for (int i = 0; i <childCount ; i++) {
                //得到当前的子控件
                View view = getChildAt(i);
                //测量当前子控件
                view.measure(0,0);
                //获得子控件高度
                int height = view.getMeasuredHeight();
                //获得子控件宽度
                int width = view.getMeasuredWidth();
                //获得屏幕宽度
                int widthPixels = getResources().getDisplayMetrics().widthPixels;
                rigth=left+width;
                //b)（核心）当一行放不下的时候可以在第二行显示，并且根据内容长度不同，每行显示的数量也不同
                if(rigth>widthPixels-50){
                    left=0;
                    rigth=left+width;
                    top=bootom+30;
                }
                bootom=top+height;
                view.layout(left,top,rigth,bootom);
                left=left+width+30;
            }
        }
    }
    public void addlist(List<String> list){
        if(list.size()>0){
            for (int i = 0; i <list.size() ; i++) {
                final String s = list.get(i);
                TextView textView = new TextView(getContext());
                textView.setText(s);
                addView(textView);
              //  c)（核心）给显示的内容设置点击事件，点击吐司内容（例如：点击图1中的散文，吐司散文。点击图1中的设计，吐司设计）
                textView.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(App.getContext(),s, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
    }
    public void addText(final String name){
                TextView textView = new TextView(getContext());
                textView.setText(name);
                addView(textView);
                //c)（核心）给显示的内容设置点击事件，点击吐司内容（例如：点击图1中的散文，吐司散文。点击图1中的设计，吐司设计）
        textView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(App.getContext(),name, Toast.LENGTH_SHORT).show();
            }
        });
            }
}
