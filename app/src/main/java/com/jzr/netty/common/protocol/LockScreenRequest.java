package com.jzr.netty.common.protocol;


import com.jzr.netty.common.base.BaseMsg;
import com.jzr.netty.common.base.MsgType;

public class LockScreenRequest extends BaseMsg {
    public LockScreenRequest() {
        super();
        setType(MsgType.LOCK_SCREEN);
    }
}