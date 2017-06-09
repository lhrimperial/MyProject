package com.handy.frame.server.web.security;

import java.lang.annotation.*;

/**
 * @author longhairen
 * @create 2017/6/9 0009 上午 10:26
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface CookieNonCheckRequired {
}
