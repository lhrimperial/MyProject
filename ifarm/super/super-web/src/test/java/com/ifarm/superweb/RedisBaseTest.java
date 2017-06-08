package com.ifarm.superweb;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;

import java.util.Arrays;
import java.util.List;

/**
 * @author longhairen
 * @create 2017-05-21 10:33
 * @description
 **/
public class RedisBaseTest {

    private static String host = "192.168.157.128";
    private static int port = 6379;

    public static void main(String[] args) {
//        test();
        test5shardNormal();
    }

    public static void test5shardNormal() {
        List<JedisShardInfo> shards = Arrays.asList(
                new JedisShardInfo(host,6379),
                new JedisShardInfo(host,6378));

        ShardedJedis sharding = new ShardedJedis(shards);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            String result = sharding.set("sn" + i, "n" + i);
        }
        long end = System.currentTimeMillis();
        System.out.println("Simple@Sharing SET: " + ((end - start)/1000.0) + " seconds");

        sharding.disconnect();
    }

    public static void test(){
        Jedis jedis = new Jedis(host);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            String result = jedis.set("n" + i, "n" + i);
        }
        long end = System.currentTimeMillis();
        System.out.println("Simple SET: " + ((end - start)/1000.0) + " seconds");
        jedis.disconnect();
    }


}
