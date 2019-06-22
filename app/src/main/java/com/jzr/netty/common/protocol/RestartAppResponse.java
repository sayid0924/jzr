package com.jzr.netty.common.protocol;

import com.jzr.netty.common.base.MsgType;
import com.jzr.netty.common.base.ResponseMsg;

public class RestartAppResponse extends ResponseMsg {
    private Integer deviceCount;
    public RestartAppResponse(){
        super();
        this.setType(MsgType.RESTART_APP);
    }
}
