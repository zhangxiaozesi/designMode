package com.zhangs.pattern.factory.factory_method;

//咖啡类
public abstract class Coffee2 {
    public abstract void getName();
    public void addMilk(){
        System.out.println("咖啡加奶");
    }
    public void addSweet(){
        System.out.println("咖啡加糖");
    }
}
