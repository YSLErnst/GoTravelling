package com.hand.ysl.netty.dto;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;

/**
 * Created by Ernst on 2017/12/25.
 */
public class HelloServerInitializer extends ChannelInitializer{
    @Override
    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        pipeline.addLast("framer",new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));

        pipeline.addLast("decoder",new StringDecoder());
        pipeline.addLast("encoder",new StringDecoder());

        pipeline.addLast("handler",new HelloServerHandler());
    }
}
