package com.hand.ysl.demo.design.proxyDesign.dto;

import com.hand.ysl.demo.design.proxyDesign.Interface.BuyCar;

/**
 * Created by Ernst on 2017/8/22.
 */
public class ProxyClass implements BuyCar{
    //代理类持有真实对象的引用，以便可以调用真实对象的方法
    private People perple;

    public People getPerple() {
        return perple;
    }

    public void setPerple(People perple) {
        this.perple = perple;
    }

    @Override
    public void buyCar() {
         if(perple.getVip().equals("vip")){
             perple.buyCar();
         }
        if(perple.getCash()>50000){
            System.out.println(perple.getName()+"买了新车，交易结束");
        }else{
            System.out.println(perple.getName()+"钱不够，不买");
        }
    }
}
