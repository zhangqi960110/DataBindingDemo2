package com.example.zhangqi.databindingdemo2;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.zhangqi.databindingdemo2.adapter.MyRecyclerViewAdapter;
import com.example.zhangqi.databindingdemo2.bean.User;
import com.example.zhangqi.databindingdemo2.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<User> users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置Toolbar
        ActivityMainBinding mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainBinding.toolbar.setTitle("Android Data Binding代码实战");
        mainBinding.toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(mainBinding.toolbar);

        initData();

        //设置RecyclerView
        mainBinding.recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(this,users);
        mainBinding.recyclerView.setAdapter(adapter);

    }
    public void initData(){
        users = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            users.add(new User("姓名:用户"+i,"密码:zxy"+i,i));
        }
    }
}