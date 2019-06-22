package com.jzr.netty.common.protocol;

import com.jzr.netty.common.base.BaseMsg;
import com.jzr.netty.common.base.MsgType;

public class ReloadDataRequest extends BaseMsg {
    public ReloadDataRequest(){
        super();
        this.setType(MsgType.RELOAD_DATA);
    }
}
