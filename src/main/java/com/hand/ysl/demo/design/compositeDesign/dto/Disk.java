package com.hand.ysl.demo.design.compositeDesign.dto;

/**
 * Created by Ernst on 2017/9/7.
 */
public class Disk extends Equipment{

    public static double diskOriginPrice = 3.0;

    public static double diskDiscountPrice = 2.0;

    public Disk(String name){
        super(name);
    }

    @Override
    public double originPrice() {
        return diskOriginPrice;
    }

    @Override
    public double discountPrice() {
        return diskDiscountPrice;
    }
}
