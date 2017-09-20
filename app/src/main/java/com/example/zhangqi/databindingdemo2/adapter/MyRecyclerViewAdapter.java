package com.example.zhangqi.databindingdemo2.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;


import com.example.zhangqi.databindingdemo2.BR;
import com.example.zhangqi.databindingdemo2.R;
import com.example.zhangqi.databindingdemo2.bean.User;
import com.example.zhangqi.databindingdemo2.databinding.RecyclerItemBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 晓勇 on 2015/8/6 0006.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<BindingHolder> {
    private Context mContext;
    private List<User> users;
    private List<Integer> heights;
    public MyRecyclerViewAdapter(Context context,List<User> users) {
        this.mContext = context;
        this.users = users;
        initHeight();
    }
    private void initHeight(){
        heights = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            heights.add(200+(int)(300*Math.random()));
        }
    }
    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerItemBinding mItemBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.recycler_item, parent, false);
        BindingHolder mHolder = new BindingHolder(mItemBinding.getRoot());//得到根布局View设置给ViewHolder
        mHolder.setBinding(mItemBinding);//把mItemBinding设置给ViewHolder
        return mHolder;
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        ViewGroup.LayoutParams params = holder.itemView.getLayoutParams();
        params.height = heights.get(position);
        holder.itemView.setLayoutParams(params);

        //通过holder.getBinding()得到Binding Class
        User user = users.get(position);
        holder.getBinding().setVariable(BR.user,user);//动态设置数据
//        holder.getBinding().setUser(user);这种方式也行，因为User继承自BaseObservable
        holder.getBinding().executePendingBindings();//立即更新UI
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
