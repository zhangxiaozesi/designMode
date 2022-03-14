package com.zhangs.pattern.factory.simple_factory;

import com.zhangs.pattern.factory.before.Coffee;
import com.zhangs.pattern.factory.before.LatteCoffee;
import com.zhangs.pattern.factory.before.MochaCoffee;

public class CoffeeFactory {
    //订购咖啡
    public static Coffee createCoffee(String type){
        Coffee coffee=null;
        if("latte".equals(type)){
            coffee=new LatteCoffee();
        }
        if("mocha".equals(type)){
            coffee=new MochaCoffee();
        }
        return coffee;
    }
}
