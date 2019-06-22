package com.jzr.netty.common.protocol;


import com.jzr.netty.common.base.MsgType;
import com.jzr.netty.common.base.ResponseMsg;

public class CancelVideoResponse extends ResponseMsg {
    public CancelVideoResponse() {
        super();
        setType(MsgType.CANCEL_VIDEO);
    }

}