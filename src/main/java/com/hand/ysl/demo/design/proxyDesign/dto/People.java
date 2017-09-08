package com.hand.ysl.demo.design.proxyDesign.dto;

import com.hand.ysl.demo.design.proxyDesign.Interface.BuyCar;

/**
 * Created by Ernst on 2017/8/22.
 */
public class People implements BuyCar{
    private String name;

    private int cash;

    private String vip;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public String getVip() {
        return vip;
    }

    public void setVip(String vip) {
        this.vip = vip;
    }

    @Override
    public void buyCar() {
        System.out.println(name+"是vip，可以买车");
    }
}
