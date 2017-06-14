package com.handy.frame.web.service.impl;

import com.handy.frame.web.domain.Space;
import com.handy.frame.web.service.IHessianService;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 * @author longhairen
 * @create 2017/6/14 0014 下午 3:07
 */
@Component("hessianService")
public class HessianServiceImpl implements IHessianService {

    private static final Log log = LogFactory.getLog(HessianServiceImpl.class);

    private Space createSpace() {
        Space space = new Space();
        space.setPublicName("roosher-space");
        space.setPrivateName("my-private-room");
        space.setActive(true);
        space.setLastUpdatedTime(new Date());
        return space;
    }

    public Space findSpace(String id) {
        // TODO Auto-generated method stub
        log.debug("find space id is :" + id);
        return createSpace();
    }

    public List showSpaceNames() {
        // TODO Auto-generated method stub
        List names = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            names.add("Hello space "+ i);
        }
        return names;
    }

    public boolean updateSpaceName(String name) {
        // TODO Auto-generated method stub
        log.debug("updated space name : " + name );
        return true;
    }
}
