package com.jzr.bedside.service.nettyUtils;

import com.jzr.bedside.utils.PreferUtil;
import com.blankj.utilcode.utils.EmptyUtils;
import com.orhanobut.logger.Logger;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import io.netty.handler.timeout.IdleStateHandler;

public class NettyClient {

    private static NettyClient nettyClient = new NettyClient();

    private EventLoopGroup group;

    private NettyListener listener;

    private Channel channel;

    private boolean isConnect = false;

    private int reconnectNum = Integer.MAX_VALUE;

    private long reconnectIntervalTime = 5000;
    private Bootstrap bootstrap;

    public static NettyClient getInstance() {
        return nettyClient;
    }

    public synchronized NettyClient connect() {
        if (!isConnect) {
            group = new NioEventLoopGroup();
             bootstrap = new Bootstrap().group(group)
                    .option(ChannelOption.SO_KEEPALIVE, true)
                    .channel(NioSocketChannel.class)
//					.handler(new NettyClientInitializer(listener));
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new IdleStateHandler(20, 10, 0));
                            ch.pipeline().addLast(new ObjectEncoder());
                            ch.pipeline().addLast(new ObjectDecoder(ClassResolvers.cacheDisabled(null)));
                            ch.pipeline().addLast(new NettyClientHandler(listener));
                        }
                    });

            try {
                bootstrap.connect(PreferUtil.getInstance().getSoketIp(),
                        Integer.parseInt(PreferUtil.getInstance().getSoketPort())).addListener(new ChannelFutureListener() {
                    @Override
                    public void operationComplete(ChannelFuture channelFuture) throws Exception {
                        if (channelFuture.isSuccess()) {
                            Logger.e("connect  Success");
                            isConnect = true;
                            channel = channelFuture.channel();
                        } else {
                            isConnect = false;
                        }
                    }
                }).sync();
            } catch (Exception e) {
                listener.onServiceStatusConnectChanged(NettyListener.STATUS_CONNECT_ERROR);
                reconnect();
            }
        }
        return this;
    }

    public void disconnect() {
        if (EmptyUtils.isNotEmpty(group))
            group.shutdownGracefully();
        if(bootstrap!=null){
            bootstrap =null;
        }
    }

    public void reconnect() {
        if (reconnectNum > 0 && !isConnect) {
            reconnectNum--;
            try {
                Thread.sleep(reconnectIntervalTime);
            } catch (InterruptedException e) {
            }
//            Logger.e("重新连接");
            disconnect();
            connect();
        } else {
            disconnect();
        }
    }

    public boolean sendMsgToServer(Object data, ChannelFutureListener listener) {
        boolean flag = channel != null && isConnect;
        if (flag) {
            channel.writeAndFlush(data).addListener(listener);
        }
        return flag;
    }

    public void setReconnectNum(int reconnectNum) {
        this.reconnectNum = reconnectNum;
    }

    public void setReconnectIntervalTime(long reconnectIntervalTime) {
        this.reconnectIntervalTime = reconnectIntervalTime;
    }

    public boolean getConnectStatus() {
        return isConnect;
    }

    public void setConnectStatus(boolean status) {
        this.isConnect = status;
    }

    public void setListener(NettyListener listener) {
        this.listener = listener;
    }

}
