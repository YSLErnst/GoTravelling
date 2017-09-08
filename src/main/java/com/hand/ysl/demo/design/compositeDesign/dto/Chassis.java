package com.hand.ysl.demo.design.compositeDesign.dto;

/**
 * Created by Ernst on 2017/9/7.
 */
public class Chassis extends CompositeEquipment{
    public static double chassisOriginPrice = 2.0;
    public static double chassisDiscountPrice = 1.0;

    public Chassis(String name) {
        super(name);
    }

    @Override
    public double originPrice() {
        return chassisOriginPrice+super.originPrice();
    }

    @Override
    public double discountPrice() {
        return chassisDiscountPrice+super.discountPrice();
    }
}
