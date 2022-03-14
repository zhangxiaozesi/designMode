package com.zhangs.design.principle.dependency.after;

import com.zhangs.design.principle.dependency.before.IntelCpu;
import com.zhangs.design.principle.dependency.before.KingstonMemory;
import com.zhangs.design.principle.dependency.before.XiJieHardDisk;
import lombok.Data;

@Data
public class Computer {
    private Cpu intelCpu;
    private Memory kingstonMemory;
    private Disk xiJieHardDisk;

    public void run(){
        System.out.println("电脑开始运行");
        xiJieHardDisk.get();
        intelCpu.run();
        kingstonMemory.save();
    }
}
