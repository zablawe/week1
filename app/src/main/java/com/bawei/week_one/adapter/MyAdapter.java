package com.bawei.week_one.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.week_one.R;
import com.bawei.week_one.apis.App;
import com.bawei.week_one.entity.DateBean;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * author: 张奥
 * data: 2019-09-29
 * function:
 */
public class MyAdapter extends RecyclerView.Adapter<DateBean.ResultBean>  {
    private List <DateBean.ResultBean> result;
    public   TextView textView;
    public  ImageView imageView;
    public MyAdapter(List <DateBean.ResultBean> result) {

        this.result = result;
    }

    @NonNull
    @Override
    public DateBean.ResultBean onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate( App.getContext(), R.layout.item_layout, null );
        ViewHolders viewHolders = new ViewHolders(view);
        return viewHolders;
    }

    @Override
    public void onBindViewHolder(@NonNull DateBean.ResultBean resultBean, int i) {
    textView.setText( resultBean.getCommodityName() );
    Glide.with( App.getContext() ).load( resultBean.getMasterPic() ).into( imageView );
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    private class ViewHolders extends DateBean.ResultBean {



        public ViewHolders(View view) {
            super(view);
            imageView = view.findViewById( R.id.img );
            textView = view.findViewById( R.id.name );
        }
    }
}


