package com.zhangs.pattern.factory.abstarct_factory;

//意大利工厂  生产拿铁咖啡 和  提拉米苏
public class ItalyDessertFactory implements DessertFactory{
    @Override
    public Dessert createDessert() {
        return new Trimisu();
    }
    @Override
    public Coffee3 createCoffee() {
        return new LatteCoffee3();
    }
}
