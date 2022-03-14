package com.zhangs.pattern.factory.abstarct_factory;

//咖啡类
public abstract class Coffee3 {
    public abstract void getName();
    public void addMilk(){
        System.out.println("咖啡加奶");
    }
    public void addSweet(){
        System.out.println("咖啡加糖");
    }
}
