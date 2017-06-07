package com.handy.frame.server.cache;

import com.handy.frame.server.cache.exception.KeyIsNotFoundException;
import com.handy.frame.server.cache.exception.ValueIsBlankException;
import com.handy.frame.server.cache.exception.ValueIsNullException;
import com.handy.frame.server.cache.store.IRemoteCacheStore;
import com.handy.frame.server.cache.store.RedisCacheStore;
import com.handy.frame.server.database.redis.exception.RedisConnectionException;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Map;

/**
 * @author longhairen
 * @create 2017/5/23 0023 下午 4:29
 * Redis 缓存抽象类
 */
public abstract class AbstractRedisCache<V> implements ICache<String,V> {
    /**
     * 日志类
     */
    private static final Log LOG = LogFactory.getLog(AbstractRedisCache.class);

    /**
     * 数据仓库
     */
    private IRemoteCacheStore<String, V> cacheStore = new RedisCacheStore<String, V>();

    /**
     * 超时时间,单位秒,默认30分钟
     */
    protected int timeOut = 30 * 60;

    public void setCacheStore(IRemoteCacheStore<String, V> cacheStore) {
        this.cacheStore = cacheStore;
    }

    @Override
    public abstract String getUUID();

    public abstract  <V> V provider(String key);

    /**
     * 设置超时时间
     * @param seconds
     * @see
     */
    public void setTimeOut(int seconds) {
        this.timeOut = seconds;
    }

    /**
     * 根据uuid和key生成key
     * @param key
     * @return
     * @see
     */
    protected String getKey(String key) {
        return getUUID() + "_" + key;
    }

    /**
     * 获取数据
     * 如果返回null就是真的没有数据，无需再去数据库再取
     *
     * @param key
     * @return
     */
    @Override
    public V get(String key) {
        if(StringUtils.isBlank(key)) {
            throw new RuntimeException("key does not allow for null!");
        }
        V value = null;
        try {
            value = cacheStore.get(getKey(key));
        } catch(ValueIsBlankException e) {
            LOG.warn("缓存["+getUUID()+"]，key["+key+"]存在，value为空串，返回结果[null]");
            //key存在，value为空串
            return null;
        } catch(ValueIsNullException ex) {
            //key存在，value为null
            LOG.warn("缓存["+getUUID()+"]，key["+key+"]存在，value为null，返回结果[null]");
            return null;
        } catch(KeyIsNotFoundException ex1) {
            //key不存在
            value = provider(key);
            LOG.warn("缓存["+getUUID()+"]，key["+key+"]不存在，走数据库查询，返回结果["+value+"]");
            cacheStore.set(getKey(key), value, timeOut);
        } catch(RedisConnectionException exx) {
            //redis 连接出现异常
            value = provider(key);
            LOG.warn("redis连接出现异常，走数据库查询!");
            return value;
        }
        return value;
    }

    @Override
    public Map<String, V> get() {
        throw new RuntimeException(getUUID() + ":TTLCache cannot get all!");
    }

    @Override
    public void invalid() {
        throw new RuntimeException(getUUID() + ":TTLCache cannot invalid all!");
    }

    /**
     * 失效数据
     * @param key
     */
    @Override
    public void invalid(String key) {
        cacheStore.remove(getKey(key));
    }

    @Override
    public void invalidMulti(String ... keys) {
        if(keys == null) return;
        String[] skeys = new String[keys.length];
        for(int i=0;i<keys.length;i++) {
            skeys[i] = getKey(keys[i]);
        }
        cacheStore.removeMulti(skeys);
    }

    @Override
    public boolean exists(String key) {
        return false;
    }
}
