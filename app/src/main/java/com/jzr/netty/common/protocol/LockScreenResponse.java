package com.jzr.netty.common.protocol;

import com.jzr.netty.common.base.MsgType;
import com.jzr.netty.common.base.ResponseMsg;

public class LockScreenResponse extends ResponseMsg {
    public LockScreenResponse() {
        super();
        setType(MsgType.LOCK_SCREEN);
    }
}