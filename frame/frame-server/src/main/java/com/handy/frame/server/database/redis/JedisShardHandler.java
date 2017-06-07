package com.handy.frame.server.database.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author longhairen
 * @create 2017/6/7 0007 上午 10:16
 */
public class JedisShardHandler implements IRedisHandler{

    public void init(){}

    @Override
    public Long del(String key) {
        return null;
    }

    @Override
    public Long del(String... keys) {
        return null;
    }

    @Override
    public Boolean exists(String key) {
        return null;
    }

    @Override
    public Long expire(String key, int seconds) {
        return null;
    }

    @Override
    public Long persist(String key) {
        return null;
    }

    @Override
    public Long expireAt(String key, long unixTime) {
        return null;
    }

    @Override
    public Long ttl(String key) {
        return null;
    }

    @Override
    public String type(String key) {
        return null;
    }

    @Override
    public String set(String key, String value) {
        return null;
    }

    @Override
    public String get(String key) {
        return null;
    }

    @Override
    public String mset(String... keyValues) {
        return null;
    }

    @Override
    public List<String> mget(String... keys) {
        return null;
    }

    @Override
    public String setex(String key, int seconds, String value) {
        return null;
    }

    @Override
    public Long append(String key, String value) {
        return null;
    }

    @Override
    public Long hset(String key, String field, String value) {
        return null;
    }

    @Override
    public String hmset(String key, Map<String, String> hash) {
        return null;
    }

    @Override
    public List<String> hmget(String key, String... field) {
        return null;
    }

    @Override
    public Long hlen(String key) {
        return null;
    }

    @Override
    public Set<String> hkeys(String key) {
        return null;
    }

    @Override
    public List<String> hvals(String key) {
        return null;
    }

    @Override
    public Map<String, String> hgetAll(String key) {
        return null;
    }

    @Override
    public String hget(String key, String field) {
        return null;
    }

    @Override
    public Long exists(String key, String field) {
        return null;
    }

    @Override
    public Long hdel(String key, String... field) {
        return null;
    }
}
