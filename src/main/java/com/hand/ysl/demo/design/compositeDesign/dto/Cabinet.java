package com.hand.ysl.demo.design.compositeDesign.dto;

/**
 * Created by Ernst on 2017/9/7.
 */
public class Cabinet extends CompositeEquipment{
    public static double originCabinetPrice = 5.0;

    public static double discountCabinetPrice = 3.0;

    public Cabinet(String name) {
        super(name);
    }

    @Override
    public double originPrice() {
        return originCabinetPrice + super.originPrice();
    }

    @Override
    public double discountPrice() {
        return discountCabinetPrice + super.discountPrice();
    }
}
