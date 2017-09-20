package com.example.zhangqi.databindingdemo2.bean;


import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class User extends BaseObservable {
    private String userName;
    private String userPassword;
    private int userAge;

    public User(String userName,String userPassword,int userAge){
        this.userName = userName;
        this.userPassword = userPassword;
        this.userAge = userAge;
    }

    @Bindable
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Bindable
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Bindable
    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }
}
