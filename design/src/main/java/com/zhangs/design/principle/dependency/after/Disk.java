package com.zhangs.design.principle.dependency.after;

public abstract class Disk {
    //存储数据的方法
    public abstract void save(String data);

    //获取数据的方法
    public abstract String get();
}
