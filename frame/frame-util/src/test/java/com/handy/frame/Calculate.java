package com.handy.frame;

import com.handy.frame.util.date.TimeUtils;

/**
 * @author longhairen
 * @create 2017-06-11 11:33
 * @description
 **/
public class Calculate {

    public static void main(String[] args) {
        calculateIncome();
        saiche(50, 8);

        System.out.println("");

        calCount(1000, 2);
        makeM();
        System.out.println(TimeUtils.daysBetween("2017-03-06","2017-06-13"));
    }

    public static void calCount(double sum, int time){
        double count = 0;
        int income = 0;
        switch (time) {
            case 1:
                income = 35;
                break;
            case 2:
                income = 20;
                break;
            case 3:
                income = 60;
                break;
            case 4:
                income = 180;
                break;
            case 5:
                income = 540;
                break;
            case 6:
                income = 1620;
                break;
            default:
                income = 35;
        }
        count = Math.ceil(sum/income);
        System.out.println("sum: " + sum + "  第 " + time + " 次中总共需要 " + count + " 次");
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

        System.out.println(7200+2000+654+2684+1400+5000+70000);
    }
}
