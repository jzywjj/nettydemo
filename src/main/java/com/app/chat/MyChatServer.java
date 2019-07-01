package com.app.chat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
/**
 * 	1.服务器启动，n多个客户端与服务器进行连接，一个客户端上线之后，
 * 服务器端控制台会打印xx上线了，其他的客户端控制台打印xx上线了。
 * 如果一个客户端下线了，服务器端的控制台上打印，xx下线了，
 * 其他的客户端控制台打印xx下线了。
	2.多个客户端都上线之后，一个客户端（比如说A）给服务端发送消息，
	那么客户端（比如说A，B，C，包括自己本身）都会收到消息，对于A来说，
	会标志此消息是自己发送自己的，其他的客户端则会收到具体的消息。
 * @author Mk king
 *
 */
public class MyChatServer {
	
	public static void main(String[] args) throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup wokerGroup = new NioEventLoopGroup();

        try{
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup,wokerGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new MyChatServerInializer());

            ChannelFuture channelFuture = serverBootstrap.bind(8899).sync();
            channelFuture.channel().closeFuture().sync();
        }finally {
            bossGroup.shutdownGracefully();
            wokerGroup.shutdownGracefully();
        }
    }
	
	
	
}
