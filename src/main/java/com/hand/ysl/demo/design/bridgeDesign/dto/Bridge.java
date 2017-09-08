package com.hand.ysl.demo.design.bridgeDesign.dto;

import com.hand.ysl.demo.design.bridgeDesign.Interface.SourceAbles;

/**
 * Created by Ernst on 2017/8/25.
 */
public abstract class Bridge {
    private SourceAbles sourceAbles;
    public void method(){
        sourceAbles.method();
    }

    public SourceAbles getSourceAbles() {
        return sourceAbles;
    }

    public void setSourceAbles(SourceAbles sourceAbles) {
        this.sourceAbles = sourceAbles;
    }
}
