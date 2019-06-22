package com.jzr.netty.common.protocol;

import com.jzr.netty.common.base.MsgType;
import com.jzr.netty.common.base.ResponseMsg;

public class RestartDeviceResponse extends ResponseMsg {
    private Integer deviceCount;
    public RestartDeviceResponse(){
        super();
        this.setType(MsgType.RESTART_DEVICE);
    }
}
