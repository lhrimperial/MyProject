package com.ifarm.back.base.mapper;

import com.ifarm.back.base.domain.po.TermsCodeDO;
import org.springframework.stereotype.Repository;

/**
 * @author longhairen
 * @create 2017/6/14 0014 上午 9:49
 */
@Repository
public interface TermsCodeMapper {


    /**
     *
     * @param termsCode
     * @return
     */
    TermsCodeDO findTermsCodeByCode(String termsCode);

    /**
     *
     * @param termsCodeDO
     */
    void update(TermsCodeDO termsCodeDO);

    /**
     *
     * @param termsCodeDO
     */
    void insert(TermsCodeDO termsCodeDO);
}
