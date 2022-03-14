package com.zhangs.design.principle.dependency.after;

//intel  处理器
public class JinShanCpu extends Cpu{
    @Override
    public void run() {
        System.out.println("使用金山处理器");
    }
}
