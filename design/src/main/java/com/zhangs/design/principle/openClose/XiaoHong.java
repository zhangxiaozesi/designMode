package com.zhangs.design.principle.openClose;

import lombok.Data;

@Data
public class XiaoHong extends Cook {
    @Override
    public void chaoCai() {
        System.out.println("小红会炒土豆");
    }
}
