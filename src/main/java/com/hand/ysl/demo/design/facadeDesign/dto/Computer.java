package com.hand.ysl.demo.design.facadeDesign.dto;

/**
 * Created by Ernst on 2017/8/23.
 */
public class Computer {
    private CPU cpu;
    private DISK disk;
    private MEMORY memory;

    public Computer(){
        cpu = new CPU();
        disk = new DISK();
        memory = new MEMORY();
    }

    public void start(){
        cpu.start();
        disk.start();
        memory.start();
    }

    public void disconnect(){
        cpu.disconnnect();
        disk.disconnnect();
        memory.disconnnect();
    }
}
