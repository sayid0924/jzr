package com.jzr.netty.common.protocol;


import com.jzr.netty.common.base.MsgType;
import com.jzr.netty.common.base.ResponseMsg;

public class MsgNoticeResponse extends ResponseMsg {
    public MsgNoticeResponse() {
        super();
        setType(MsgType.MSG_NOTICE);
    }
}