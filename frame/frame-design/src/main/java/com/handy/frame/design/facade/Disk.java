package com.handy.frame.design.facade;

import java.util.logging.Logger;

/**
 * @author longhairen
 * @create 2017/6/26 0026 上午 9:21
 */
public class Disk {
    private Logger logger = Logger.getLogger(Disk.class.getName());

    public void start(){
        logger.info("Disk start....");
    }

    public void shoutDown(){
        logger.info("Disk shoutDown....");
    }
}
