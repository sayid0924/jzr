package com.jzr.netty.common.protocol;


import com.jzr.netty.common.base.BaseMsg;
import com.jzr.netty.common.base.MsgType;

public class CancelVideoRequest extends BaseMsg {
    public CancelVideoRequest() {
        super();
        setType(MsgType.CANCEL_VIDEO);
    }
}