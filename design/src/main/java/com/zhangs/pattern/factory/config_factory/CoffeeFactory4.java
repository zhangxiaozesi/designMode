package com.zhangs.pattern.factory.config_factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CoffeeFactory4 {
    public static Map<String,Coffee4> coffee4Map=new HashMap<>();
    //加载配置类 装进map里面
    static {
        Properties p=new Properties();
        InputStream in=CoffeeFactory4.class.getClassLoader().getResourceAsStream("bean.properties");
        try {
            p.load(in);
            Set<Object> keys = p.keySet();
            for (Object key:keys) {
                String className = p.getProperty((String) key);
                Class<?> clazz = Class.forName(className);
                Coffee4 coffee4 = (Coffee4) clazz.newInstance();
                coffee4Map.put((String) key,coffee4);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public Coffee4 getCoffee(String name){
        return coffee4Map.get(name);
    }
}
