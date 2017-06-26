package com.handy.frame.design.facade;

import java.util.logging.Logger;

/**
 * @author longhairen
 * @create 2017/6/26 0026 上午 9:22
 */
public class Memory {

    private Logger logger = Logger.getLogger(Memory.class.getName());

    public void start(){
        logger.info("Memory start....");
    }

    public void shoutDown(){
        logger.info("Memory shoutDown....");
    }
}
