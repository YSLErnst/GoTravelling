package com.hand.ysl.demo.design.bridgeDesign.dto;

import com.hand.ysl.demo.design.bridgeDesign.Interface.SourceAbles;

/**
 * Created by Ernst on 2017/8/25.
 */
public class SourceSub1 implements SourceAbles{
    @Override
    public void method() {
        System.out.println("this is sourcesub1");
    }

}
