package com.handy.frame.web.service;

import com.handy.frame.web.domain.Space;

import java.util.List;

/**
 * @author longhairen
 * @create 2017/6/14 0014 下午 3:06
 */
public interface IHessianService {
    List showSpaceNames(); //返回名字集合

    Space findSpace(String id);//找到空间名字

    boolean updateSpaceName(String name); //更新空间名字
}
