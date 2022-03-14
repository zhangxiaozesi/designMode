package com.zhangs.design.principle.richter;

public class RectangleDemo {

    //拓宽方法，如果宽小于长，则给宽加一，一直到宽 > 长为止
    public void resize(Rectangle rectangle){
        while (rectangle.getWide()<=rectangle.getLength()){
            System.out.println("wide+1");
            rectangle.setWide(rectangle.getWide()+1);
        }

    }
}
