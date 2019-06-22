package com.jzr.netty.common.protocol;


import com.jzr.netty.common.base.MsgType;
import com.jzr.netty.common.base.ResponseMsg;

public class PingResponse extends ResponseMsg {
    public PingResponse() {
        super();
        setType(MsgType.REGISTER);
    }



}