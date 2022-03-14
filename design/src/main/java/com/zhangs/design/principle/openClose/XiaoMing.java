package com.zhangs.design.principle.openClose;

import lombok.Data;

@Data
public class XiaoMing extends Cook {

    @Override
    public void chaoCai() {
        System.out.println("小明会炒鸡蛋");
    }
}
