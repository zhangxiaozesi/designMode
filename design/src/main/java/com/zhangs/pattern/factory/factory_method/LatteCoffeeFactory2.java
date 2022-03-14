package com.zhangs.pattern.factory.factory_method;

public class LatteCoffeeFactory2 implements CoffeeFactory2{
    @Override
    public Coffee2 createCoffee() {
        return new LatteCoffee2();
    }
}
