package com.example.zhangqi.databindingdemo2.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.zhangqi.databindingdemo2.databinding.RecyclerItemBinding;


/**
 * Created by 晓勇 on 2015/8/6 0006.
 */
public class BindingHolder extends RecyclerView.ViewHolder {
    private RecyclerItemBinding binding;

    public BindingHolder(View itemView) {
        super(itemView);
    }

    public RecyclerItemBinding getBinding() {
        return binding;
    }

    public void setBinding(RecyclerItemBinding binding) {
        this.binding = binding;
    }
}
