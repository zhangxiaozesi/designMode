package com.zhangs.pattern.factory.factory_method;

import com.zhangs.pattern.factory.simple_factory.Coffee1;

public class MochaCoffee2 extends Coffee2 {
    @Override
    public void getName() {
        System.out.println("摩卡咖啡");
    }
}
