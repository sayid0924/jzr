package com.jzr.netty.common.protocol;

import com.jzr.netty.common.base.BaseMsg;
import com.jzr.netty.common.base.MsgType;

public class RestartAppRequest extends BaseMsg {
    public RestartAppRequest(){
        super();
        this.setType(MsgType.RESTART_APP);
    }
}
