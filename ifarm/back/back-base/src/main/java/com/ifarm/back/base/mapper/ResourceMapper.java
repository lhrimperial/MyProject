package com.ifarm.back.base.mapper;


import com.ifarm.back.base.domain.po.ResourceDO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author longhairen
 * @create 2017/6/9 0009 下午 5:17
 */
@Repository
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
