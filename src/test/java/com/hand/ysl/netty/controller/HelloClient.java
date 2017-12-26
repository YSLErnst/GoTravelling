
package com.hand.ysl.netty.controller;

import com.hand.ysl.netty.dto.HelloClientInitializer;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Created by Ernst on 2017/12/25.
 */

public class HelloClient {
    public static String host = "127.0.0.1";
    public static int port = 7878;

    public static void main(String[] args) throws InterruptedException,IOException{
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group).channel(NioSocketChannel.class)
                    .handler(new HelloClientInitializer());

            Channel ch = bootstrap.connect(host,port).sync().channel();

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            for(;;){
                String line = in.readLine();
                if(line == null){
                    continue;
                }
                ch.writeAndFlush(line+"\r\n");
            }
        }finally {
            group.shutdownGracefully();
        }
    }
}

