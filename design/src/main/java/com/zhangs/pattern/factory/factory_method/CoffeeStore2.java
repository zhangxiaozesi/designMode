package com.zhangs.pattern.factory.factory_method;

public class CoffeeStore2 {
    private CoffeeFactory2 coffeeFactory2;
    public void setCoffeeFactory2(CoffeeFactory2 coffeeFactory2){
        this.coffeeFactory2=coffeeFactory2;
    }
    public void orderCoffee(){
        Coffee2 coffee = coffeeFactory2.createCoffee();
        coffee.getName();
        coffee.addMilk();
        coffee.addSweet();
    }
}
