package com.zhangs.pattern.factory.before;

//咖啡店
public class CoffeeStore {
    private Coffee coffee;
    //订购咖啡
    public void orderCoffee(String type){
        if("latte".equals(type)){
            coffee=new LatteCoffee();
        }
        if("mocha".equals(type)){
            coffee=new MochaCoffee();
        }
        coffee.getName();
        coffee.addMilk();
        coffee.addSweet();
    }
}
