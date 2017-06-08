package com.handy.frame;

import com.handy.frame.util.date.DateUtils;
import com.handy.frame.util.date.TimeUtils;

/**
 * @author longhairen
 * @create 2017/6/8 0008 下午 2:42
 */
public class DateTest {

    public static void main(String[] args){
        int count = TimeUtils.daysBetween("2017-03-06","2017-05-20");
        System.out.println(count);

    }
}
