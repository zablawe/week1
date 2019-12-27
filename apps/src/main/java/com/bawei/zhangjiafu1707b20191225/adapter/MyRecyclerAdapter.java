package com.bawei.zhangjiafu1707b20191225.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;



import com.bawei.zhangjiafu1707b20191225.R;
import com.bawei.zhangjiafu1707b20191225.entity.ListEntity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

/**
 * @author: 张家辅
 * @date: 2019/12/25
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyHoder> {
    //变量
    Context context;
    List<ListEntity.ResultBean> result;

    public MyRecyclerAdapter(Context context, List<ListEntity.ResultBean> result) {
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public MyHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.recyclerlayout, null);
        MyHoder myHoder = new MyHoder(inflate);
        return myHoder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHoder holder, int position) {
        //b)（复习）展示的图片使用Glide圆型处理，配置占位图和错误图
        Glide.with(context).load(result.get(position).getMasterPic())
                .apply(new RequestOptions().transform(new RoundedCorners(50)))
                .error(R.mipmap.ic_launcher_round)
                .placeholder(R.mipmap.ic_launcher_round)
                .into(holder.image);
        holder.text.setText(result.get(position).getCommodityName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.success();
            }
        });
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class MyHoder extends RecyclerView.ViewHolder {
        TextView text;
        ImageView image;
        public MyHoder(@NonNull View itemView) {
            super(itemView);
           image= itemView.findViewById(R.id.lay_image);
           text= itemView.findViewById(R.id.lay_text);
        }
    }
    CallBack callBack;

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }

    public interface CallBack{
        void success();
    }
}
