package com.handy.frame.design.facade;

import java.util.logging.Logger;

/**
 * @author longhairen
 * @create 2017/6/26 0026 上午 9:29
 */
public class Client {
    private static Logger logger = Logger.getLogger(Client.class.getName());

    public static void main(String[] args){
        Computer computer = new Computer();
        computer.start();

        logger.info("======================================");

        computer.shoutDown();
    }
}
