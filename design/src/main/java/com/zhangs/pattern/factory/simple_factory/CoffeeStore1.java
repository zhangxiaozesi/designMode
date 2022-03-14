package com.zhangs.pattern.factory.simple_factory;

import com.zhangs.pattern.factory.before.Coffee;
import com.zhangs.pattern.factory.before.LatteCoffee;
import com.zhangs.pattern.factory.before.MochaCoffee;

//咖啡店
public class CoffeeStore1 {
    public void orderCoffee(String type){
        Coffee coffee = CoffeeFactory.createCoffee(type);
        coffee.getName();
        coffee.addSweet();
        coffee.addMilk();
    }
}
