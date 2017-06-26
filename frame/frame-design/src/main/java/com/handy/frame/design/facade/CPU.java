package com.handy.frame.design.facade;

import java.util.logging.Logger;

/**
 * @author longhairen
 * @create 2017/6/26 0026 上午 9:19
 */
public class CPU {
    private Logger logger = Logger.getLogger(CPU.class.getName());

    public void start(){
       logger.info("CPU Start....");
    }

    public void shoutDown(){
        logger.info("CPU shoutDown....");
    }
}
