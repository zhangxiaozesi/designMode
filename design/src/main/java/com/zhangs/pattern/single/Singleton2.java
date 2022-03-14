package com.zhangs.pattern.single;

//单类模式   懒汉模式
public class Singleton2 {
    private Singleton2(){};
    private static Singleton2 singleton;
    public static synchronized Singleton2 getSingleton(){
        if(singleton==null){
            singleton = new Singleton2();
        }
        return singleton;
    }

}
