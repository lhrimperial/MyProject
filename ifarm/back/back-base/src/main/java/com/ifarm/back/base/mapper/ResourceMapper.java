package com.ifarm.back.base.mapper;


import com.ifarm.back.base.domain.po.ResourcePO;
import org.springframework.stereotype.Repository;

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
    ResourcePO findResourceByResCode(String resCode);

    /**
     *
     * @param resourcePO
     */
    void insert(ResourcePO resourcePO);

    /**
     *
     * @param resourcePO
     */
    void update(ResourcePO resourcePO);
}
