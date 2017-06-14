package com.ifarm.superback.mapper;

import com.ifarm.superback.domain.po.TermsValueDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author longhairen
 * @create 2017/6/14 0014 上午 9:55
 */
@Repository
public interface TermsValueMapper {

    /**
     *
     * @param termsCode
     * @return
     */
    List<TermsValueDO> findTermsValues(String termsCode);

    /**
     *
     * @param termsCode
     * @param valueCode
     * @return
     */
    TermsValueDO findTermsValueByCode(@Param("termsCode") String termsCode, @Param("valueCode")String valueCode);

    /**
     *
     * @param termsValueDO
     */
    void update(TermsValueDO termsValueDO);
    /**
     *
     * @param termsValueDO
     */
    void insert(TermsValueDO termsValueDO);
}
