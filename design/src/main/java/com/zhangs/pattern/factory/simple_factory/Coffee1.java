package com.zhangs.pattern.factory.simple_factory;

//咖啡类
public abstract class Coffee1 {
    public abstract void getName();
    public void addMilk(){
        System.out.println("咖啡加奶");
    }
    public void addSweet(){
        System.out.println("咖啡加糖");
    }
}
