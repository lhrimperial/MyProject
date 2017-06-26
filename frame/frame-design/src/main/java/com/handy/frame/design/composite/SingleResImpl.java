package com.handy.frame.design.composite;

/**
 * @author longhairen
 * @create 2017/6/26 0026 下午 6:00
 */
public class SingleResImpl implements IRes {

    private String name;

    private double money;

    public SingleResImpl(String name, double money) {
        this.name = name;
        this.money = money;
    }

    @Override
    public void pay() {
        System.out.println("购买了一件物品["+getName()+"],价钱是[" + getMoney()+"]元");
    }

    /**重写equals*/
    public boolean equals(Object obj){
        SingleResImpl res = (SingleResImpl)obj;
        return res.getName().equals(getName()) && res.getMoney()==getMoney();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
