package com.zhangs.pattern.single;

//单类模式   饿汉模式
public class Singleton {
    private Singleton(){};
    private static Singleton singleton=new Singleton();
    public static Singleton getSingleton(){
        return singleton;
    }
}
