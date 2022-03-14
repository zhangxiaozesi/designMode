package com.zhangs.pattern.single;

import java.io.Serializable;


public class Singleton5 implements Serializable {
    private Singleton5(){};

    private static class  Singleton5Holder{
        private static final Singleton5 s=new Singleton5();
    }

    public static Singleton5 getSingleton(){
        return Singleton5Holder.s;
    }

    //序列化破坏单例模式解决方法: 重写readResolve方法
    public Object readResolve(){
        return Singleton5.getSingleton();
    }
}
