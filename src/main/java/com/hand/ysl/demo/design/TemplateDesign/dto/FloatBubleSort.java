package com.hand.ysl.demo.design.TemplateDesign.dto;

/**
 * Created by Ernst on 2017/9/13.
 */
public class FloatBubleSort extends BubleSorter {
    private float[] array = null;

    public int Sort(float[] theArray){
        this.array = theArray;
        this.length = theArray.length;
        return DoSort();
    }

    @Override
    protected boolean outOfOrder(int index) {
        return array[index]>array[index+1];
    }

    @Override
    protected void swap(int index) {
        float temp = array[index];
        array[index] = array[index+1];
        array[index+1] = temp;
    }
}
