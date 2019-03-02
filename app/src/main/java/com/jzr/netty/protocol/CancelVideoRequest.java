package com.jzr.netty.protocol;

import com.jzr.netty.base.BaseMsg;
import com.jzr.netty.base.MsgType;

public class CancelVideoRequest extends BaseMsg {
    public CancelVideoRequest() {
        super();
        setType(MsgType.CANCEL_VIDEO);
    }
}