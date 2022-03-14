package com.zhangs.pattern.single;

//单类模式   饿汉模式  静态代码块创建对象
public class Singleton1 {
    private Singleton1(){};
    private static Singleton1 singleton;
    static {
        singleton=new Singleton1();
    }
    public static Singleton1 getSingleton(){
        return singleton;
    }

}
