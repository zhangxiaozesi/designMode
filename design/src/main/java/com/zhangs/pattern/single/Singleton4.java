package com.zhangs.pattern.single;

//单例模式   懒汉模式   静态内部类方式
public class Singleton4 {
    private Singleton4(){};

    private static class SingletonHolder{
        private static final Singleton4 singleton4=new Singleton4();
    }

    public static Singleton4 getSingleton(){
        return SingletonHolder.singleton4;
    }

}
