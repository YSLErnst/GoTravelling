package com.hand.ysl.netty.controller;

import com.hand.ysl.netty.dto.HelloServerInitializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by Ernst on 2017/12/25.
 */

public class HelloServer {
    //服务端监听的端口地址
    private static final int portNumber = 7878;

    public static void main(String[] args) throws InterruptedException{
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try{
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup,workerGroup);
            bootstrap.channel(NioServerSocketChannel.class);
            bootstrap.childHandler(new HelloServerInitializer());

            //服务器绑定端口监听
            ChannelFuture channelFuture = bootstrap.bind(portNumber).sync();
            //监听服务器关闭监听
            channelFuture.channel().closeFuture().sync();

        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
