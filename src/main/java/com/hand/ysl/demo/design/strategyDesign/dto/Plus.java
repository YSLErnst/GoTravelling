package com.hand.ysl.demo.design.strategyDesign.dto;

import com.hand.ysl.demo.design.strategyDesign.Interface.ICaculator;

/**
 * Created by Ernst on 2017/9/11.
 */
public class Plus extends AbstractCaculator implements ICaculator{
    @Override
    public int caculate(String exp) {
        int arr[] = split(exp,"\\+");
        return arr[0]+arr[1];
    }
}
