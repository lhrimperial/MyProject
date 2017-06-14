package com.handy.frame;

import com.handy.frame.util.date.TimeUtils;

/**
 * @author longhairen
 * @create 2017-06-11 11:33
 * @description
 **/
public class Calculate {

    public static void main(String[] args) {
//        calculateIncome();
//        saiche(50, 8);
        makeM();
        System.out.println(TimeUtils.daysBetween("2017-03-06","2017-06-13"));
    }

    public static void makeM(){
        int days = TimeUtils.daysBetween("2017-06-15", "2017-12-31");
        System.out.println(days);
        int income = days * 1000;
        System.out.println(income);
    }

    public static void saiche(int start, int len){
        int sum = 0, per = start, income = 0;
        for (int i = 1; i <= len; i++) {
            if (i == 1) {
                per = start;
            } else if (i == 2) {
                per *= 2;
            } else {
                per *= 3;
            }
            sum += per;
            income = per / 10 * 17 - sum;
            System.out.println("i : " + i + "   per: " + per + "    sum: " + sum + "    income: " + income);
        }
    }

    /**
     *
     */
    public static void calculateIncome(){
        System.out.println(
                7000
                +12488
                +11206
                +13593.53
                +13593.53
                +13590
                +9533
                +12102.5
        );
    }
}
