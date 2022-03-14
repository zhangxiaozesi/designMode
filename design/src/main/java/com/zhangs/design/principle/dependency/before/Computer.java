package com.zhangs.design.principle.dependency.before;

import lombok.Data;

@Data
public class Computer {
    private IntelCpu intelCpu;
    private KingstonMemory kingstonMemory;
    private XiJieHardDisk xiJieHardDisk;

    public void run(){
        System.out.println("电脑开始运行");
        xiJieHardDisk.get();
        intelCpu.run();
        kingstonMemory.save();
    }
}
