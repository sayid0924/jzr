package com.jzr.bedside.service.nettyUtils;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import com.jzr.netty.common.base.BaseMsg;


public class NettyClientHandler  extends SimpleChannelInboundHandler<BaseMsg> {

    private NettyListener listener;
    public NettyClientHandler(NettyListener listener){
        this.listener = listener;
    }
    
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		NettyClient.getInstance().setConnectStatus(true);
		listener.onServiceStatusConnectChanged(NettyListener.STATUS_CONNECT_SUCCESS);
	}
	
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		NettyClient.getInstance().setConnectStatus(false);
		listener.onServiceStatusConnectChanged(NettyListener.STATUS_CONNECT_CLOSED);
		NettyClient.getInstance().reconnect();
		
	}

	@Override
	protected void channelRead0(ChannelHandlerContext channelHandlerContext,  BaseMsg baseMsg) throws Exception {
		listener.onMessageResponse(baseMsg);
	}


	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}




}
