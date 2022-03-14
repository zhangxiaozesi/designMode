package com.zhangs.pattern.single;

import java.io.Serializable;

public class Singleton6 implements Serializable {
    private static boolean flag=false;
    private Singleton6(){
        //反射获取对象破坏单例模式解决方法:   构造里面判断对象是否重复
        synchronized (Singleton6.class){
            if(flag){
                throw new RuntimeException("不能创建多个对象");
            }
            flag=true;
        }
    };

    private static class  Singleton5Holder{
        private static final Singleton6 s=new Singleton6();
    }

    public static Singleton6 getSingleton(){
        return Singleton5Holder.s;
    }

}
