package com.handy.frame.web.mapper;

import com.handy.frame.web.domain.AutoUser;
import org.springframework.stereotype.Repository;

/**
 * @author longhairen
 * @create 2017/5/8 0008 下午 4:20
 */
@Repository
public interface AutoUserMapper {

    public void saveAutoUser(AutoUser autoUser);

    public AutoUser findAutoUser(int id);

}
