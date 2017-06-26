package com.handy.frame.design.adapter;

/**
 * @author longhairen
 * @create 2017-06-25 15:45
 * @description
 **/
public class Rocket {

    private String name;
    private String price;
    private String apogee;

    public Rocket(String name, String price, String apogee){
        this.name = name;
        this.price = price;
        this.apogee = apogee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getApogee() {
        return apogee;
    }

    public void setApogee(String apogee) {
        this.apogee = apogee;
    }
}
