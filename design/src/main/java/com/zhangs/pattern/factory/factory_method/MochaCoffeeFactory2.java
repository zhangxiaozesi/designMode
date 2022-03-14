package com.zhangs.pattern.factory.factory_method;

public class MochaCoffeeFactory2 implements CoffeeFactory2{
    @Override
    public Coffee2 createCoffee() {
        return new MochaCoffee2();
    }
}
