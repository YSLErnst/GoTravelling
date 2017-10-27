package com.hand.ysl.demo.design.strategyDesign.dto;

/**
 * Created by Ernst on 2017/9/11.
 */
public abstract class AbstractCaculator {
    public int[] split(String exp,String opt){
        String array[] = exp.split(opt);
        int arrInt[] = new int[2];
        arrInt[0] = Integer.parseInt(array[0]);
        arrInt[1] = Integer.parseInt(array[1]);
        return arrInt;
    }
}
