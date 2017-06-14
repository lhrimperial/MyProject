package com.ifarm.superbase.mapper;


import com.ifarm.superbase.domain.po.ResourceDO;

/**
 * @author longhairen
 * @create 2017/6/9 0009 下午 5:17
 */

public interface ResourceMapper {

    /**
     *
     * @param resCode
     * @return
     */
    ResourceDO findResourceByResCode(String resCode);

    /**
     *
     * @param resourceDO
     */
    void insert(ResourceDO resourceDO);

    /**
     *
     * @param resourceDO
     */
    void update(ResourceDO resourceDO);
}
