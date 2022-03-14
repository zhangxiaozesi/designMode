package com.zhangs.pattern.factory.factory_method;

import com.zhangs.pattern.factory.before.Coffee;
import com.zhangs.pattern.factory.before.LatteCoffee;
import com.zhangs.pattern.factory.before.MochaCoffee;

public interface CoffeeFactory2 {
    public abstract Coffee2 createCoffee();
}
