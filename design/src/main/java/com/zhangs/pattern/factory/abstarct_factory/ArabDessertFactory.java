package com.zhangs.pattern.factory.abstarct_factory;

//阿拉伯工厂  生产摩卡咖啡 和  炸糖丸
public class ArabDessertFactory implements DessertFactory{
    @Override
    public Dessert createDessert() {
        return new Luqaimat();
    }
    @Override
    public Coffee3 createCoffee() {
        return new MochaCoffee3();
    }
}
