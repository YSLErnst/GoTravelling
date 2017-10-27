package com.hand.ysl.demo.design.TemplateDesign.dto;

/**
 * Created by Ernst on 2017/9/13.
 */
public abstract class BubleSorter {
    private int operations = 0;

    protected int length = 0;

    protected int DoSort(){
        operations = 0;
        if(length<=1){
            return operations;
        }

        for(int nextToLast = length-2;nextToLast>=0;nextToLast--){
            for(int index=0;index<=nextToLast;index++){
                  if(outOfOrder(index)){
                      swap(index);
                  }
                operations++;
            }
        }
        return operations;
    }

    protected abstract boolean outOfOrder(int index);

    protected abstract void swap(int index);
}
