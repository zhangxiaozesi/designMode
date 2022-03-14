package com.zhangs.pattern.factory.before;

//咖啡类
public abstract class Coffee {
    public abstract void getName();
    public void addMilk(){
        System.out.println("咖啡加奶");
    }
    public void addSweet(){
        System.out.println("咖啡加糖");
    }
}
