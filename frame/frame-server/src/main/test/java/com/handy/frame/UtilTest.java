package com.handy.frame;

import com.handy.frame.util.ValidateUtils;

/**
 * @author longhairen
 * @create 2017/6/8 0008 下午 5:19
 */
public class UtilTest {

    public static void main(String[] args){
        double num = 78989.79;
        System.out.println(ValidateUtils.isNumeric(num+""));
    }
}
