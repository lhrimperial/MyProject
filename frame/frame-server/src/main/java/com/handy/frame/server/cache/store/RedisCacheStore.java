package com.handy.frame.server.cache.store;

/**
 * @author longhairen
 * @create 2017/6/7 0007 上午 9:47
 */
public class RedisCacheStore<K, V> implements IRemoteCacheStore<K, V> {


    @Override
    public boolean set(K key, V value) {
        return false;
    }

    @Override
    public boolean set(K key, V value, int exp) {
        return false;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public void remove(K key) {

    }

    @Override
    public void removeMulti(K[] keys) {

    }
}
