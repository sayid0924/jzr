package com.jzr.netty.common.protocol;


import com.jzr.netty.common.base.BaseMsg;
import com.jzr.netty.common.base.MsgType;

public class CaptureScreenRequest extends BaseMsg {

    public CaptureScreenRequest() {
        super();
        setType(MsgType.CAPTURE_SCREEN);
    }
}