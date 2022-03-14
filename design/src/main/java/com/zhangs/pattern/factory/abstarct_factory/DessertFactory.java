package com.zhangs.pattern.factory.abstarct_factory;
// 甜品工厂  生产咖啡和甜点
public interface DessertFactory {
    public Dessert createDessert();
    public Coffee3 createCoffee();
}
