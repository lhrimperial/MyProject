package com.handy.frame.design.facade;

import java.util.logging.Logger;

/**
 * @author longhairen
 * @create 2017/6/26 0026 上午 9:24
 */
public class Computer {
    private Logger logger = Logger.getLogger(Computer.class.getName());

    private CPU cpu;
    private Disk disk;
    private Memory memory;

    public Computer() {
        cpu = new CPU();
        disk = new Disk();
        memory = new Memory();
    }


    public void start() {
        logger.info("Computer start....");
        cpu.start();
        disk.start();
        memory.start();
    }

    public void shoutDown(){
        logger.info("Computer shoutDown...");
        cpu.shoutDown();
        disk.shoutDown();
        memory.shoutDown();
    }

}


