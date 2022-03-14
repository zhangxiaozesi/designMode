package com.zhangs.design.principle.dependency.after;

//intel  处理器
public class IntelCpu extends Cpu{
    @Override
    public void run() {
        System.out.println("使用Intel处理器");
    }
}
