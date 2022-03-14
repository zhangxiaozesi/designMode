package com.zhangs.pattern.single;

//单类模式   懒汉模式   双重检查锁方式
public class Singleton3 {
    private Singleton3(){};
    private static Singleton3 singleton;
    public static synchronized Singleton3 getSingleton(){
        //如果不为空不需要占锁
        if(singleton==null){
            synchronized (Singleton3.class){
                if(singleton==null){
                    singleton = new Singleton3();
                }
            }
        }
        return singleton;
    }
}
