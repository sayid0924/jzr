package com.jzr.netty.common.protocol;

import com.jzr.netty.common.base.MsgType;
import com.jzr.netty.common.base.ResponseMsg;

public class CaptureScreenResponse extends ResponseMsg {
    public CaptureScreenResponse() {
        super();
        setType(MsgType.CAPTURE_SCREEN);
    }
}