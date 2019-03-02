package com.jzr.netty.protocol;

import com.jzr.netty.base.BaseMsg;
import com.jzr.netty.base.MsgType;

public class LockScreenRequest extends BaseMsg {

    public LockScreenRequest() {
        super();
        setType(MsgType.LOCK_SCREEN);
    }
}