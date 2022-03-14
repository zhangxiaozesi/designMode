package com.zhangs.design.principle.richter;

//正方形
public class Square extends Rectangle {
    //重写父类长方形的set,get方法,使长宽相等
    @Override
    public void setLength(int length) {
        super.setLength(length);
        super.setWide(length);
    }

    @Override
    public void setWide(int wide){
        super.setWide(wide);
        super.setLength(wide);
    }
}
