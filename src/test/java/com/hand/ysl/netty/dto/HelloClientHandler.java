package com.hand.ysl.netty.dto;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by Ernst on 2017/12/25.
 */
public class HelloClientHandler extends SimpleChannelInboundHandler<String>{
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println("Server say : "+msg);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception{
        System.out.println("client active ");
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception{
        System.out.println("client close ");
        super.channelInactive(ctx);
    }


}
