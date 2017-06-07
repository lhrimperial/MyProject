package com.handy.frame;

import com.handy.frame.server.database.redis.RedisClient;
import com.handy.frame.util.FastJsonUtil;

/**
 * @author longhairen
 * @create 2017/6/7 0007 下午 5:31
 */
public class RedisClientTest {

    public static void main(String[] args) throws Exception{
        test();
    }

    public static void test() throws Exception{
        RedisClient redisClient = new RedisClient();
        RedisClient.DEFUALT_CONFIG = "redis-template.properties";
        redisClient.afterPropertiesSet();
        Person person = new Person(1, "zhangqing", "123456");
        redisClient.set("person", FastJsonUtil.toJsonString(person));
    }
}
