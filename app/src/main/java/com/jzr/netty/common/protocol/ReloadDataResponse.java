package com.jzr.netty.common.protocol;

import com.jzr.netty.common.base.MsgType;
import com.jzr.netty.common.base.ResponseMsg;

public class ReloadDataResponse extends ResponseMsg {
    private Integer deviceCount;
    public ReloadDataResponse(){
        super();
        this.setType(MsgType.RELOAD_DATA);
    }



}
