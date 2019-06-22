package com.jzr.netty.common.protocol;

import com.jzr.netty.common.base.MsgType;
import com.jzr.netty.common.base.ResponseMsg;

public class UpgradeResponse extends ResponseMsg {
    private Integer deviceCount;
    public UpgradeResponse() {
        super();
        setType(MsgType.UPGRADE);
    }

}
