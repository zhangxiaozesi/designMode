package com.zhangs.design.principle.openClose;


public class Boss {
    //老板招聘，需要根据菜品招厨师
    public void recruit(Cook cook){
        cook.chaoCai();
    }
}
