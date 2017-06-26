package com.handy.frame.design.composite;

import java.util.Iterator;
import java.util.Vector;

/**
 * @author longhairen
 * @create 2017/6/26 0026 下午 6:54
 */
public class MultiResImpl  implements IRes {
    /**购物车*/
    private Vector car = new Vector();
    private static double totle = 0.0;

    public void pay() {
        if(!car.isEmpty()){
            System.out.println("名称        价格\n");
            shopping();
            System.out.println("\n总价:" + totle + "元");
        }else{
            System.out.println("您好，你没有购买任何物品，不用买单！");
        }
    }

    public void shopping() {
        if (car != null || !car.isEmpty()) {
            Iterator it = car.iterator();
            SingleResImpl res = null;
            Object temp = null;// 临时对象
            while (it.hasNext()) {
                temp = it.next();
                if (temp instanceof MultiResImpl) {
                    ((MultiResImpl) temp).shopping();
                } else {
                    res = (SingleResImpl) temp;
                    synchronized (this) {
                        totle += res.getMoney();
                    }
                    System.out.println(res.getName() + "            " + res.getMoney()
                            + "元");
                }
            }
        }
    }
    /**加入新的物品*/
    public void addRes(IRes res) {
        car.add(res);
    }

    /**放回物品*/
    public void removeRes(IRes res) {
        car.remove(res);
    }

}
