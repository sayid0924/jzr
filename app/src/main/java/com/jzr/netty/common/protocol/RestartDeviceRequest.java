package com.jzr.netty.common.protocol;

import com.jzr.netty.common.base.BaseMsg;
import com.jzr.netty.common.base.MsgType;


public class RestartDeviceRequest extends BaseMsg {
    public RestartDeviceRequest(){
        super();
        this.setType(MsgType.RESTART_DEVICE);
    }
}
