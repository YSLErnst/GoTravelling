package com.hand.ysl.demo.design.TemplateDesign.dto;

/**
 * Created by Ernst on 2017/9/13.
 */
public class IntBubleSort extends BubleSorter {
    private int[] array = null;

    public int Sort(int[] theArray){
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
        int temp = array[index];
        array[index] = array[index+1];
        array[index+1] = temp;
    }
}
